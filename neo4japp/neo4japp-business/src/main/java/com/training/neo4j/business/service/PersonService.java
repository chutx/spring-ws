package com.training.neo4j.business.service;

import java.util.Set;

import com.training.neo4j.dao.entities.Country;
import com.training.neo4j.dao.entities.Person;

public interface PersonService {

	Person setCountryForPerson(Person person, Country country);
	
	Set<Person> getPeopleFromCountry(Country country);
}
