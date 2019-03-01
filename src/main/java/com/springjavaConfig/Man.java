package com.springjavaConfig;

import org.springframework.beans.factory.annotation.Autowired;

public class Man {
	
	public  Person person;
	
	  @Autowired
	public Man(Person person) {
		super();
		this.person = person;
	}




	public  void manInfo() {
		System.out.println("这是一个男人");
	}

}
