package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.RoleDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.daoimpl.CategoryDAOImpl;
import com.niit.shoppingcart.daoimpl.ProductDAOImpl;
import com.niit.shoppingcart.daoimpl.RoleDAOImpl;
import com.niit.shoppingcart.daoimpl.SupplierDAOImpl;
import com.niit.shoppingcart.daoimpl.UserDAOImpl;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Role;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;


@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement
public class Applicationconfig {
	
//	database
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/Shoppingcart");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		
		return dataSource;
	}

//databaseconfiguration	
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Role.class);
	
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired(required=true)
	@Bean(name="UserDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		
		return new UserDAOImpl(sessionFactory);
		
	}
	
	@Autowired(required=true)
	@Bean(name="CategoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		return new CategoryDAOImpl(sessionFactory);
		
	}
	@Autowired(required=true)
	@Bean(name="ProductDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		return new ProductDAOImpl(sessionFactory);
		
	}
	@Autowired(required=true)
	@Bean(name="SupplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		return new SupplierDAOImpl(sessionFactory);
		
	}
	@Autowired(required = true)
	@Bean(name = "RoleDAO")
	public RoleDAO getRoleDAO(SessionFactory sessionFactory) {
		return new RoleDAOImpl(sessionFactory);
	}
}
