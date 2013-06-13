package com.training.architecture.java.app.dao.service;

import com.training.architecture.java.app.dao.entities.PersonPO;

public interface PersonDao {

	void persistPerson(PersonPO personPO);
	
	PersonPO fetchPerson(Long id);
}
