package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

@Repository("SupplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(String id, String email) {
		Query query = sessionFactory.getCurrentSession().createQuery(" from Supplier where id = ? and name = ?");
		query.setString(0, id); // actually the index will start from zero -
								// will get once exception.
		query.setString(1, email);

		if (query.uniqueResult() == null) {
			// means no row exist i.e., invalid credentials
			return false;
		} else {
			// means row exist i.e., valid credentials
			return true;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Supplier> list() {
		// TODO Auto-generated method stub
		List<Supplier> list = sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		return list;
	}

	public Supplier get(String id) {
		// TODO Auto-generated method stub
		return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, id);
	}
}
