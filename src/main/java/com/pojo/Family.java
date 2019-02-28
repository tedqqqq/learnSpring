package com.pojo;

public class Family {
	
	private Person person;
	
	public Family(Person person) {
		this.person=person;		
	}
	
	public void FamilyInfo() {
		 System.out.println(person.info());
	}
	

}
