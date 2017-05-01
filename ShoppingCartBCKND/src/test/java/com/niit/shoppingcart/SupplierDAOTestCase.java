package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase {
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static SupplierDAO supplierDAO;
	
	@Autowired
	static Supplier supplier;
	
	/*
	 * public SupplierDAOTestCase(){
	 *
	 * }
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		
		supplier = (Supplier) context.getBean("supplier");
	}
	
	@Test
	public void createSupplierDAOTestCase(){
		
		supplier.setName("Kishore");
		supplier.setEmail("kishorekaruna253@gmail.com");
		supplier.setAddress("Hosur");
		supplier.setContact("7868841868");
		boolean flag = supplierDAO.save(supplier);
		
		System.out.println(flag);
		assertEquals("createSupplierDAOTestCase", true, flag);
	}
	
}
