package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {
	
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	//public boolean delete(Supplier supplier);
	public boolean validate(String id, String email);
	public List<Supplier> list();
	public Supplier get(String id);

}
