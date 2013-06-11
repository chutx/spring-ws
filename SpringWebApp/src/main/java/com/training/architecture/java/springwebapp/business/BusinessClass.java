package com.training.architecture.java.springwebapp.business;

import com.training.architecture.java.springwebapp.domain.Person;

public interface BusinessClass {

	String sayHello(Long id);
	
	void savePerson(Person person);
	
	void updatePerson(Person person, Long id);
}
