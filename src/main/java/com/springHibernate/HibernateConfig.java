package com.springHibernate;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 说明  注意此处事务的处理
 * @author invengo
 *
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
public class HibernateConfig implements TransactionManagementConfigurer{
	
	
	@Autowired
	private ComboPooledDataSource comboPooledDataSource;
	@Autowired
	private SessionFactory sessionFactory;
	  //使用C3P0连接池创建数据源
	  //自动会注入Person的对象
	  @Bean
	  public ComboPooledDataSource dataC3P0Source() {
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

//提供统一的异常管理
	  @Bean
	  public BeanPostProcessor persistenceTranslation() {
		  return new PersistenceExceptionTranslationPostProcessor();
	  }
	  
	  //开启事务
	  public PlatformTransactionManager annotationDrivenTransactionManager() {
		    System.out.println(sessionFactory);
		    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		    transactionManager.setSessionFactory(sessionFactory);
		    return transactionManager;
		  }
	  
	  @Bean
	  public SessionFactory sessionFactoryBean() {
	    try {
	      LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
	      lsfb.setDataSource(comboPooledDataSource);
	      lsfb.setPackagesToScan("com.springHibernate");
	      
	      Properties props = new Properties();
	      props.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
	      lsfb.setHibernateProperties(props);
	      lsfb.afterPropertiesSet();
	      SessionFactory object = lsfb.getObject();
	      return object;
	    } catch (IOException e) {
	      return null;
	    }
	  }
	  
}
