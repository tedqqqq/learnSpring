package com.springRedis;

import java.io.Serializable;

//注意一定要序列化
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
