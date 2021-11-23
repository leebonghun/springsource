package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.mapper.PersonMapper;

@Service("person")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonMapper mapper;
	
	@Override
	public boolean insertPerson(String id, String name) {
		// TODO Auto-generated method stub
		return mapper.insertPerson(id, name) > 0?true:false;
	}

	@Override
	public String selectPerson(String id) {
		// TODO Auto-generated method stub
		return mapper.selectPerson(id);
	}

	@Override
	public boolean updatePerson(String id, String name) {
		// TODO Auto-generated method stub
		return mapper.updatePerson(id, name)>0?true:false;
	}

	@Override
	public boolean deletePerson(String id) {
		// TODO Auto-generated method stub
		return mapper.deletePerson(id)>0?true:false;
	}

}
