package com.training.neo4j.business.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.training.neo4j.business.service.PersonService;
import com.training.neo4j.dao.entities.Friendship;
import com.training.neo4j.dao.entities.location.Country;
import com.training.neo4j.dao.repositories.CountryRepository;
import com.training.neo4j.dao.repositories.PersonRepository;

public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public Friendship setCountryForPerson(Friendship person, Country country) {
		Friendship result = null;
		person.setCountry(country);
		result = personRepository.save(person);
		return result;
	}

	@Transactional
	public Set<Friendship> getPeopleFromCountry(Country country) {
		return null;
	}

}
