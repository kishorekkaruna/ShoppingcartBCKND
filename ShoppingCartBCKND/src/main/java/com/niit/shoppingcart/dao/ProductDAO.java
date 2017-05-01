package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {
	
	public boolean save(Product product);

	// update the product details - update
	public boolean update(Product product);

	//public boolean delete(Product product);
	public boolean validate(String id, String password);
	// get all users - list

	public List<Product> list();

	// get product details based on userID

	public Product get(String id);
}
