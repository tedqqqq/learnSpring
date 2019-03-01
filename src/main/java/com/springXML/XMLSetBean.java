package com.springXML;

import java.util.List;

public class XMLSetBean {
	
	public  SimpleBean simpleBean;
	public String name;
	public List<String> listAddress;
	
	public SimpleBean getSimpleBean() {
		return simpleBean;
	}
	public String getName() {
		return name;
	}
	public List<String> getListAddress() {
		return listAddress;
	}
	public void setSimpleBean(SimpleBean simpleBean) {
		this.simpleBean = simpleBean;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setListAddress(List<String> listAddress) {
		this.listAddress = listAddress;
	}
	@Override
	public String toString() {
		return "XMLSetBean [simpleBean=" + simpleBean + ", name=" + name + ", listAddress=" + listAddress + "]";
	}

    
}
