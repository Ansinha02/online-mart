package com.narayan.corps.martdbbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = {"com.narayan.corps.martdbbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	
	//DBMS management variables
	//Changed with the change of the database in use
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlinemartdb";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	//dataSource bean
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//giving the database connection related information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;	
	}
	
	//sessionFactory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		
		sessionBuilder.scanPackages("com.narayan.corps.martdbbackend.dto");
		sessionBuilder.addProperties(getHibernateProperties());
		
		return sessionBuilder.buildSessionFactory();
	}

	//Returning all the Hibernate properties via this method
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();	
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		
		return properties;
	}

	//HibernateTransactionManager Bean
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		
		return hibernateTransactionManager;
	}
	
}

