package com.spring;

public class Person {
	
	private String name ;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String info() {
		 return "我是一个人类";
	}

}
