package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.dao.BillingaddressDAO;
import com.niit.shoppingcart.domain.Billingaddress;

public class BillingaddressDAOImpl implements BillingaddressDAO {

	public BillingaddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Billingaddress> list(String id) {
		// TODO Auto-generated method stub
		String hql = "from Billingaddress where id='" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Billingaddress> list = (List<Billingaddress>) query.list();

		return list;

	}
	@Transactional
	public void delete(String Billingaddress) {
		Billingaddress billingaddressToDelete = new Billingaddress();
		billingaddressToDelete.setBillingId(Billingaddress);
		sessionFactory.getCurrentSession().delete(billingaddressToDelete);
	}

	
	@Transactional
	public void saveOrUpdate(Billingaddress billingaddress) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(billingaddress);
	}

	@Transactional
	public void save(Billingaddress billingaddress) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(billingaddress);
	}

	

	

	@Transactional
	public List<Billingaddress> getByEmail(String email) {
		// TODO Auto-generated method stub
		String hql = "from Billingaddress where userMailId=" + "'" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Billingaddress> list = (List<Billingaddress>) query.list();

		return list;
	}

}