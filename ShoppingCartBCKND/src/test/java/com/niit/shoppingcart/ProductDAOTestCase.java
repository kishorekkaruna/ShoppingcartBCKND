package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductDAOTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;

	@Autowired
	static Product product;

	/*
	 * public ProductDAOTestCase() { initialize();
	 * 
	 * }
	 */
	@BeforeClass
	public static void initialize() {
		// TODO Auto-generated method stub
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("ProductDAO");

		product = (Product) context.getBean("product");

	}

	@Test
	public  void createProductDAOTestCase() {
		// TODO Auto-generated method stub

		product.setName("LevisShirt");
		product.setPrice("1200");
		product.setCategory("Men");
		boolean flag = productDAO.save(product);

		System.out.println(flag);

		assertEquals("createProductDAOTestCase", true, flag);

	}

}
