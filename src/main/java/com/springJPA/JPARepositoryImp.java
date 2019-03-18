package com.springJPA;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public class JPARepositoryImp implements JPARepository{
	

	@PersistenceContext
	private EntityManager em;

	@Override
	public City getCityMessage(int id) {
		// TODO Auto-generated method stub
		return em.find(City.class, id);
	}

}
