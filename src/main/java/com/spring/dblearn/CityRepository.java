package com.spring.dblearn;

public interface CityRepository {
	
	public String addCity(City city) ;
	
	public City findCityById(int id);

}
