package com.springXML;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class XMLConstructorBean {
	
	public SimpleBean simpleBean;
	public String name;
	public List<String> address;

	@Autowired
	public XMLConstructorBean(SimpleBean simpleBean, String name, List<String> address) {
		super();
		this.simpleBean = simpleBean;
		this.name = name;
		this.address = address;
	}

	

	
	@Override
	public String toString() {
		return "XMLConstructorBean [simpleBean=" + simpleBean + ", name=" + name + ", address=" + address + "]";
	}




	public String play() {
		return "构造器Bean";
	}

}
