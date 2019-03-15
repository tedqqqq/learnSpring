package com.springHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;	
	@Column(name="province_id")
	private int province_id;
	@Column(name="city_name")
	private String city_name;
	@Column(name="description")
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
