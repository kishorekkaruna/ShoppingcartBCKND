package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	// write category defined constructor with one parameter i.e.,
	// sessionFactory

	public CategoryDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
		} catch (Exception e) {
			// if any excpetion comes during execute of try block, catch will
			// excute
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/*
	 * @Transactional public boolean delete(Category category) { try {
	 * sessionFactory.getCurrentSession().delete(category); }catch (Exception e)
	 * { //if any excpetion comes during execute of try block, catch will excute
	 * e.printStackTrace(); return false; } return true; }
	 */

	public boolean validate(String id, String description) {

		Query query = sessionFactory.getCurrentSession().createQuery(" from Category where id = ? and description = ?");
		query.setString(0, id); // actually the index will start from zero -
								// will get once exception.
		query.setString(1, description);

		if (query.uniqueResult() == null) {
			// means no row exist i.e., invalid credentials
			return false;
		} else {
			// means row exist i.e., valid credentials
			return true;
		}

	}

	@SuppressWarnings("unchecked")

	public List<Category> list() {

		List<Category> list = sessionFactory.getCurrentSession().createQuery("from Category").list();
		return list;
	}

	public Category get(String id) {

		// get method get the date from category table based on primary key
		// i.e., id
		// and set it to Category class
		// like select * from category where id = ?
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);

	}
}
