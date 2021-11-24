package com.company.service;

import java.util.List;

import com.company.domain.PersonDTO;

public interface PersonService {
	public boolean insertPerson(String id,String name);
	
	public String selectPerson(String id);
	
	public boolean updatePerson(String id,String name);
	
	public boolean deletePerson(String id);
	
	public List<PersonDTO> all();
}
