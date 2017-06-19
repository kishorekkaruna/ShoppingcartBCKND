package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.RoleDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Role;
import com.niit.shoppingcart.domain.User;

public class UserDAOTestCase {
	
	@Autowired static AnnotationConfigApplicationContext context;

	@Autowired static UserDAO userDAO;

	@Autowired static User user;
	
	@Autowired
	static RoleDAO roleDAO;

	@Autowired
	static Role role;


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

		roleDAO = (RoleDAO) context.getBean("RoleDAO");

		role = (Role) context.getBean("role");

	}

	@Test
	public void createUserDAOTestCase() {
		
		user.setName("indhu");
		user.setPassword("indhu");
		user.setEmail("email");
		
		user.setConfirm("confirm");
		user.setEnabled(true);
		
		role.setMobilenumber(98765421);
		role.setRole("ADMIN");
		role.setEmail("hi@bye.com");
		role.setRole("user");
		

		user.setRole(role);
		role.setUser(user);

		roleDAO.save(role);


		
		
		boolean flag = userDAO.save(user);
		
		System.out.println(flag);

		// error - if there is in runtime errors - Red mark
		// success - if expected and actual is same - green mark
		// fail - if expected and actual is different - blue mark
		assertEquals("createUserDAOTestCase", true, flag);

	}

	
}
