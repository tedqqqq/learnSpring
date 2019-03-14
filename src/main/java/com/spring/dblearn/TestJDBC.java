package com.spring.dblearn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JDBCConfig.class)
public class TestJDBC {

@Autowired
private DataSource dataSource;

@Autowired
private ComboPooledDataSource  comboPooledDataSource;




  @Test
  public void count()  {
	  Connection ds;
	try {
		ds = dataSource.getConnection();
		PreparedStatement ps=ds.prepareStatement("select * from city");
		  ResultSet rs=ps.executeQuery();
		  System.out.println(rs.first());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }


  @Test
  public void Test() {
	  try {
		comboPooledDataSource.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }





}
