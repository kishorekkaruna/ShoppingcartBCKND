package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {
	
	@Autowired static AnnotationConfigApplicationContext context;

	@Autowired static UserDAO userDAO;

	@Autowired static User user;

	/*public UserDAOTestCase() {
		initialize();
		createUserDAOTestCase();

		// TODO Auto-generated constructor stub
	}*/

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();

		// get the userDAO from context
		userDAO = (UserDAO) context.getBean("UserDAO");

		// get the user from context

		user = (User) context.getBean("user");

	}

	@Test
	public void createUserDAOTestCase() {
		
		user.setName("indhu");
		user.setPassword("indhu");
		user.setEmail("email");
		user.setUsername("username");
		user.setConfirm("confirm");
		boolean flag = userDAO.save(user);
		
		System.out.println(flag);

		// error - if there is in runtime errors - Red mark
		// success - if expected and actual is same - green mark
		// fail - if expected and actual is different - blue mark
		assertEquals("createUserDAOTestCase", true, flag);

	}

	/*@Test
	public void updateUserTestCase() {
		user.setId("jayesh");
		user.setName("jayesh Kumar");
		user.setPassword("jayesh");
		user.setRole("ROLE_USER");
		user.setContact("8888888");
		boolean flag = userDAO.update(user);

		// error - if there is in runtime errors - Red mark
		// success - if expected and actual is same - green mark
		// fail - if expected and actual is different - blue mark
		assertEquals(" update user test case", true, flag);

	}

	@Test
	public void validateUSerTestCase() {

		boolean flag = userDAO.validate("jayesh", "jayeshhh");

		assertEquals(true, flag);

	}

	@Test
	public void getAllUserTestCase() {
		int actualSize = userDAO.list().size();

		// will compare actual and expected
		// if actual and expected is same - TC will pass
		// if it is different - TC fail
		assertEquals(12, actualSize);
	}*/

}
