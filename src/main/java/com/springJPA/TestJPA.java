package com.springJPA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JPAConfig.class)
public class TestJPA {



@Autowired
private JPARepository  jPARepository;



//对事务的创建
  @Test
  @Transactional
  public  void findCity() {
	  	System.out.println(jPARepository.getCityMessage(1).getCity_name());
  }

}
