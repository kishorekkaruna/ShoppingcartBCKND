package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ShippingAddressDAO;
import com.niit.shoppingcart.domain.ShippingAddress;

@Transactional
@Repository("ShippingAddressDAO")
public class ShippingAddressDAOImpl implements ShippingAddressDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ShippingAddressDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<ShippingAddress> list(String id) {
		String Strg="from ShippingAddress where shippingId='"+id+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(Strg);
		List<ShippingAddress> list=(List<ShippingAddress>)query.list();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ShippingAddress getUserName(String username) {
		String hql="from ShippingAddress where userName='"+username+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<ShippingAddress> listShippnAdrs=(List<ShippingAddress>) query.list();
		if(listShippnAdrs!=null&&!listShippnAdrs.isEmpty()){
			return listShippnAdrs.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ShippingAddress getShippingId(String ShippingId) {
		String ShpId="from ShippingAddress where shippingId='"+ShippingId+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(ShpId);
		List<ShippingAddress> lstspadrs=(List<ShippingAddress>) query.list();
		if(lstspadrs!=null&&!lstspadrs.isEmpty()){
			return lstspadrs.get(0);
		}
		return null;
	}

	
	public void save(ShippingAddress shippingaddress) {
		
		sessionFactory.getCurrentSession().save(shippingaddress);
	}

	
	public void update(ShippingAddress shippingaddress) {
		
		sessionFactory.getCurrentSession().save(shippingaddress);
	}

	
	public void delete(String shippingId) {
		ShippingAddress shippingaddressTodelete=new ShippingAddress();
		shippingaddressTodelete.setShippingId(shippingId);
		sessionFactory.getCurrentSession().delete(shippingaddressTodelete);
		
	}

	
	public void editshippingadd(ShippingAddress shippingaddress) {
		
		
	}

	
	public List<ShippingAddress> getUserByUserMailId(String email) {
		String hql = "from ShippingAddress where userMailId =" + "'" + email + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ShippingAddress> list = (List<ShippingAddress>) query.list();
		return list;	
	}

	


}
