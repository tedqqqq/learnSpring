package com.spring.dblearn;

public class City {
	
	private int id;
	private int province_id;
	private String city_name;
	private String description;
	public City() {
		super();
	}
	public int getId() {
		return id;
	}
	public int getProvince_id() {
		return province_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public String getDescription() {
		return description;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
