package com.springJPA;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@ComponentScan
@Configuration            
public class JPAConfig   {
	
	
	@Autowired 
	private EntityManagerFactory  emf;
	
	//数据源
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
	 
	 //jpaVendorAdapter
	  @Bean
	  public JpaVendorAdapter jpaVendorAdapter() {
	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.MYSQL);
	    adapter.setShowSql(true);
	    adapter.setGenerateDdl(false);
	    adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	    return adapter;
	  }
	  
	  //实体管理器工厂
	  @Bean
	  public LocalContainerEntityManagerFactoryBean emf(ComboPooledDataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource);
	    emf.setPersistenceUnitName("City");
	    emf.setJpaVendorAdapter(jpaVendorAdapter);
	    emf.setPackagesToScan("com.springJPA");
	    return emf;
	  }

	  //必须要  使用 @PersistenceContext @PersistenceUtil
	  @Bean
	  public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
		  return new PersistenceAnnotationBeanPostProcessor();
	  }
	  
	  //事务管理
	  @Configuration
	  @EnableTransactionManagement
	  public static class TransactionConfig implements TransactionManagementConfigurer {
	    @Autowired
	    private EntityManagerFactory emf;

	    public PlatformTransactionManager annotationDrivenTransactionManager() {
	      JpaTransactionManager transactionManager = new JpaTransactionManager();
	      transactionManager.setEntityManagerFactory(emf);
	      return transactionManager;
	    }    
	  }
}
