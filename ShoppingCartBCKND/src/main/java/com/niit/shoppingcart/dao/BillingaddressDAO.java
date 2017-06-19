package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Billingaddress;

public interface BillingaddressDAO {

	public List<Billingaddress> list(String id);

	public void delete(String billingaddress);

	public void save(Billingaddress billingaddress);
	
	public void saveOrUpdate(Billingaddress billingaddress);

	public List<Billingaddress> getByEmail(String email);

}
