package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

@Autowired
private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter i.e., sessionFactory
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean save(User user) {
		try
		{
		sessionFactory.getCurrentSession().save(user);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(User user) {
		try
		{
		sessionFactory.getCurrentSession().update(user);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validate(String id, String password) {
		
		
	Query query=	 sessionFactory.getCurrentSession().createQuery(" from User where id = ? and password = ?");
	query.setString(0, id);     //actually the index will start from zero  - will get once exception.
	query.setString(1, password);
	//in the User table with this id and password there will one or zero records will exist
	//i.e., uniqueResult
	//uniqueResult method will return object if a row exist, else it will return null
	 if(  query.uniqueResult()  == null)
	 {
		 //means no row exist i.e., invalid credentials
		 return false;
	 }
	 else
	 {
		 //means row exist i.e., valid credentials
		 return true;
	 }
	
	}

	@SuppressWarnings("unchecked")

	public List<User> list() {
		
		
		List<User> list =  sessionFactory.getCurrentSession().createQuery("from User").list();
		return list;
	}

	
	public User get(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to User class
		//like select * from user where id = ?
	  return 	(User)  sessionFactory.getCurrentSession().get(User.class, id);
		
	}
}
