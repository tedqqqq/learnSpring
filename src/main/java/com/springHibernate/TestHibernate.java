package com.springHibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HibernateConfig.class)
public class TestHibernate {



@Autowired
private HibernateRepository  cityRepository;



  @Test
  @Transactional
  public  void findCity() {
	  System.out.println(cityRepository.getCityMessage(1).getCity_name());
  }

}
