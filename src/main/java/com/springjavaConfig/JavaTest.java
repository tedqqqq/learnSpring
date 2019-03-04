package com.springjavaConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JavaConfig.class)
public class JavaTest {

//	  @Autowired
//	  private Person person;
	  
	  @Autowired
	  private Man man;
	  
  @Test
  public void cdShouldNotBeNull() {
	//  person.personInfo();
	  man.manInfo();
  }
	@Autowired
	Environment env;
	
	@Test
	public void jdj() {
		System.out.println(env.containsProperty("name"));
	}


}
