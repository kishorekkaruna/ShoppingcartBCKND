package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.ShippingAddress;

public interface ShippingAddressDAO {

	public List<ShippingAddress> list(String id);
	public ShippingAddress getUserName(String username);
	public ShippingAddress getShippingId(String ShippingId);
	public void save(ShippingAddress shippingaddress);
	public void update(ShippingAddress shippingaddress);
	public void delete(String shippingId);
	public void editshippingadd(ShippingAddress shippingaddress);
	public List<ShippingAddress> getUserByUserMailId(String email);
	
}
