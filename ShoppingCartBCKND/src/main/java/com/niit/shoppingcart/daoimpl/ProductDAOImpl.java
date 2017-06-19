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

	
	
	public void save(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	public void update(Product product) {
		// TODO Auto-generated method stub
	
		sessionFactory.getCurrentSession().update(product);
	}
	
	@Transactional
	public Product get(String pid) {

		// get method get the date from category table based on primary key
		// i.e., id
		// and set it to Product class
		// like select * from category where id = ?
		String hql = "from Product where pid ='" + pid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) (query).list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		return null;
	}
	
	
	public boolean validate(String id, String name) {
		
		
	Query query=	 sessionFactory.getCurrentSession().
			createQuery(" from Product where pid = ? and name = ?");
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



	@Override
	public void deleteById(String productId) {
		// TODO Auto-generated method stub
		Product productToDelete = new Product();
		productToDelete.setPid(productId);
		sessionFactory.getCurrentSession().delete(productToDelete);

	}



	@Override
	public List<Product> getByCategory(String category) {
		String hql = "from Product where category ='" + category + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) (query).list();

		
		return listProduct;
	}

	
		
	

}
