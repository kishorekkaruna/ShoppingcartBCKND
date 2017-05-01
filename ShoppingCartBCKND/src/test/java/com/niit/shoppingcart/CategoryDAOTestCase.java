package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryDAOTestCase {

	@Autowired static AnnotationConfigApplicationContext context;

	@Autowired static CategoryDAO categoryDAO;

	@Autowired static Category category;

	/*public CategoryDAOTestCase() {
		initialize();
		createCategoryDAOTestCase();

		// TODO Auto-generated constructor stub
	}
	*/
	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("CategoryDAO");
		
		category = (Category) context.getBean("category");
	}
	
	
	@Test
	public void createCategoryDAOTestCase(){
		
		category.setDescription("value");
		category.setName("Men");
		boolean flag = categoryDAO.save(category);
		System.out.println(flag);
		
		assertEquals("createCategoryDAOTestCase", true, flag);
	}
	
}
