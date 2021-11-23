package com.company.service;

public interface PersonService {
	public boolean insertPerson(String id,String name);
	
	public String selectPerson(String id);
	
	public boolean updatePerson(String id,String name);
	
	public boolean deletePerson(String id);
}
