package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Product;

public interface ProductDAO {
	
	public void save(Product product);
	public void update(Product product);
	
	public boolean validate(String id, String password);
	
	public List<Product> list();

	public Product get(String pid);
	public void deleteById(String productId);
	public List<Product> getByCategory(String category);
	}
