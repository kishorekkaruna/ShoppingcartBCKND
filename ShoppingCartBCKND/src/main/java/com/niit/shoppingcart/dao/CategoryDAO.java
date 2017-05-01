package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {
	
	public boolean save(Category category);

	// update the category details - update
	public boolean update(Category category);

	//public boolean delete(Category category);

	// get all users - list
	public boolean validate(String id, String description);

	public List<Category> list();

	// get category details based on userID

	public Category get(String id);
}
