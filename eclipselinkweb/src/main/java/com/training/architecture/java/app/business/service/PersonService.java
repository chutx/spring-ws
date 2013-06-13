package com.training.architecture.java.app.business.service;

import java.util.List;

import com.training.architecture.java.app.domain.Person;

public interface PersonService {

	void savePerson(Person person);
	
	Person getPerson(Long id);
	
	List<Person> getPeople();
}
