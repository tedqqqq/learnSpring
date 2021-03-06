package com.springAutoBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AutoConfig.class)
public class AutoTest {

	@Autowired
    private 	AutoWireBean  autoWireBean;
  
	@Autowired
	private InjectBean  injectBean;
  @Test
  public void cdShouldNotBeNull() {
	  autoWireBean.testAuto();
	  autoWireBean.testInject(injectBean);
  }



}
