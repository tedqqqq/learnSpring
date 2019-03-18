package com.springHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//自动装配此对象
@Repository
public class HibernateRepositoryImp implements HibernateRepository{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateRepositoryImp(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}	

	public  Session getCurrectSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public City getCityMessage(int id) {
		// TODO Auto-generated method stub
			return (City) getCurrectSession().get(City.class, id); 

	}

}
