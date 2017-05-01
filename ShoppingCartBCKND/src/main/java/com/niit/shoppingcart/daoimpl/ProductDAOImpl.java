package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	
	
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().update(product);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean validate(String id, String name) {
		
		
	Query query=	 sessionFactory.getCurrentSession().
			createQuery(" from Product where id = ? and name = ?");
	query.setString(0, id);     //actually the index will start from zero  - will get once exception.
	query.setString(1, name);
	
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
	

	public List<Product> list() {
		// TODO Auto-generated method stub
		List<Product> list =  sessionFactory.getCurrentSession().createQuery("from Product").list();
		return list;
	}

	
	public Product get(String id) {
		// TODO Auto-generated method stub
		return (Product)  sessionFactory.getCurrentSession().get(Product.class, id);
	}	
	

}
