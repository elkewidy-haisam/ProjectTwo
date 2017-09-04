package com.positivity.servlets;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;

import com.positivity.model.*;
import com.positivity.model.UserRole;

@Configuration
@EnableTransactionManagement // enables transaction management
@ComponentScan(basePackages={"com.positivity.dao"}) // enables component scanning
public class BlogConfig {
	
	//Spring Beans
	
	//1. User
	@Bean
	public User user() {
		
		User user = new User();
		
		user.setUser_id(1300);
		user.setEmail("bye.felicia@gmail.com");
		user.setFirstname("Bye");
		user.setLastname("Felicia");
		user.setPassword("password");
		user.setUserrole_id(1000100);
		user.setUsername("bye.felicia");
		
		return user;
		
	}
	
	//2. User Role
	@Bean
	public UserRole userRole() {
		
		UserRole userRole = new UserRole();
		userRole.setDescription(userRole.getDescription());
		userRole.setUser_role_id(userRole.getUser_role_id());
		
		return userRole;
		
	}
	
	//3. Blogpost
	@Bean
	public BlogPost blogpost() {
		
		BlogPost blogpost = new BlogPost();
		blogpost.setBlogpost_content("Spring Bean blogpost.");
		blogpost.setBlogpost_id(1);
		blogpost.setBlogpost_user_id(1300);
		
		return blogpost;
		
	}
	
	//4. Comment
	@Bean
	public Comment comment() {
		
		Comment comment = new Comment();
		comment.setComment_id(12);
		comment.setUser_id(1300);
		comment.setBlogpost_id(1);
		
		return comment;
		
	}
	
	//5. UserComment
	@Bean
	public UserComment userComment() {
		
		UserComment userComment = new UserComment();
		userComment.setCommentContent("This is a Spring Bean Blog Post comment.");
		userComment.setUsersID(1300);
		userComment.setCommentID(12);
		
		return userComment;
		
	}
	
	
	
	//Autowire the created beans into Java Objects for ease of reference.
	//The idea here is that you can autowire any bean into an object for use.
	
	@Autowired
	private User user;
	
	@Autowired
	private BlogPost blogpost;
	
	@Autowired
	private Comment comment;
	
	
	

	
	
	// Contextual Sessions
	
	//DataSource
	@Bean
	public DataSource data() {
		BasicDataSource da = new BasicDataSource();
		da.setDriverClassName("oracle.jdbc.OracleDriver");
		da.setUrl("jdbc:oracle:thin:@chinook-1707-java.crwnhws3xbwv.us-east-2.rds.amazonaws.com:1521:ORCL");
		da.setUsername("username");
		da.setPassword("password");
		
		return da;
	}
	
	//Hibernate Transaction Manager
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	   HibernateTransactionManager txManager = new HibernateTransactionManager();
	   txManager.setSessionFactory(sessionFactory);
	 
	   return txManager;
	   
	}
	 
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    
		return new PersistenceExceptionTranslationPostProcessor();
	    
	}
	
	//SessionFactory
	@Bean
	public AnnotationSessionFactoryBean sessionFactory(DataSource da) {
		AnnotationSessionFactoryBean sfb = new AnnotationSessionFactoryBean();
		sfb.setDataSource(da);
		sfb.setPackagesToScan(new String[] {"com.positivity.model"});
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.setProperty("hibernate.hb,2ddl.auto", "update");
		props.setProperty("show_sql", "true");
		sfb.setHibernateProperties(props);
		
		return sfb;
	}
	

	
	
}
	
