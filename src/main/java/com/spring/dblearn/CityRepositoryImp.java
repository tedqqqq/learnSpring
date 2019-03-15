package com.spring.dblearn;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryImp implements CityRepository{
	
	private JdbcOperations jdbcOperations;

	@Autowired
	public CityRepositoryImp(JdbcOperations jdbcOperations) {
		super();
		this.jdbcOperations = jdbcOperations;
	}
	private static final String INSERT_City= "insert into City (id, province_id, city_name, description) values (?, ?, ?, ?)";
	
	public String addCity(City city) {
		jdbcOperations.update(INSERT_City, city.getId(),city.getProvince_id(),city.getCity_name(),city.getDescription());
		return "进入addCity" ;
	}

	@Override
	public City findCityById(int id) {
		// TODO Auto-generated method stub
		return jdbcOperations.queryForObject("Select * from City where id =?", new CityRowMapper() , id);
	}
	
	private static final class CityRowMapper implements RowMapper<City> {
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id= rs.getInt("id");
			int province_id=rs.getInt("province_id");
			String city_name=rs.getString("city_name");
			String description=rs.getString("description");
            City city=new City();
            city.setCity_name(city_name);
            city.setDescription(description);
            city.setId(id);
            city.setProvince_id(province_id);
		    return city;
		}
	}
}
