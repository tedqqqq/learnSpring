package com.spring.dblearn;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration

public class JDBCConfig {
	
	//使用JDBC的数据源
	  @Bean
	  public DataSource dataSource() {
	  	DriverManagerDataSource ds=new DriverManagerDataSource();
	  	ds.setDriverClassName(" com.mysql.jdbc.Driver");
	  	ds.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8");
	  	ds.setUsername("root");
	  	ds.setPassword("11111111");
	  	return ds;
	  }
	  
//	  @Bean
//	  public JndiObjectFactoryBean  JNDIDataSource() {
//		  JndiObjectFactoryBean  jo=new JndiObjectFactoryBean();
//		  jo.setJndiName("myJndiName");
//		  jo.setResourceRef(true);
//		  jo.setProxyInterface(javax.sql.DataSource.class);
//		  return jo;
//	  }

	  //使用C3P0连接池创建数据源
	  //自动会注入Person的对象
	  @Bean
	  public ComboPooledDataSource dataC3P0Source(Person person) {
		  person.personInfo();
		  ComboPooledDataSource ds=new ComboPooledDataSource();
		  try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  ds.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8");
		  ds.setUser("root");
	  	ds.setPassword("11111111");
	  	ds.setInitialPoolSize(3);
	  	return ds;
	  }
	  
	  //使用JDBCTemple模板进行数据库的操作
	  
	  @Bean 
	  public Person getPerosn() {
		return   new Person();
	  }
}
