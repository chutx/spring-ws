package com.training.architecture.java.springwebapp.dao;

import java.util.List;

import com.training.architecture.java.springwebapp.entities.PersonPO;

public interface PersonDao {

	void addPerson(PersonPO person);
	
	void updatePerson(PersonPO person);
	
	PersonPO fetchPerson(Long id);
	
	List<PersonPO> fetchPersonList(Integer page, Integer numOfRecords);
}
