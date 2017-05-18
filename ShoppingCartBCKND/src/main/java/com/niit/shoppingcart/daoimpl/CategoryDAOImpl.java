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

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// write category defined constructor with one parameter i.e.,
	// sessionFactory

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
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

	@Transactional
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

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Category> list() {

		List<Category> list = sessionFactory.getCurrentSession().createQuery("from Category").list();
		return list;
	}

	@Transactional
	public Category get(String id) {

		// get method get the date from category table based on primary key
		// i.e., id
		// and set it to Category class
		// like select * from category where id = ?
		String hql = "from Category where id ='" + id + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) (query).list();

		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		return null;
	}

	@Transactional
	public void deleteById(String categoryId) {
		// TODO Auto-generated method stub
		Category categoryToDelete = new Category();
		categoryToDelete.setId(categoryId);
		sessionFactory.getCurrentSession().delete(categoryToDelete);

	}
}
