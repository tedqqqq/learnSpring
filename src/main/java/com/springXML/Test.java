package com.springXML;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "XMLbean.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

	@Autowired
	private XMLConstructorBean  xmlConstructorBean;
	
	@Autowired
	private XMLSetBean xmlSetBean;
	
	 @org.junit.Test
  public void cdShouldNotBeNull() {
		 	System.out.println(xmlConstructorBean.toString());
  }

	 
	 @org.junit.Test
  public void secondTest() {
		 	System.out.println(xmlSetBean.toString());
  }

}