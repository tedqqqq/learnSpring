package com.springjavaConfig;

public class Man {
	
	public Man(Person person) {
		super();
		this.person = person;
	}

	public  Person person;


	public  void manInfo() {
		System.out.println("这是一个男人");
	}

}
