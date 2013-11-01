package com.training.neo4j.business.service;

import java.util.Set;

import com.training.neo4j.dao.entities.Friendship;
import com.training.neo4j.dao.entities.location.Country;

public interface PersonService {

	Friendship setCountryForPerson(Friendship person, Country country);
	
	Set<Friendship> getPeopleFromCountry(Country country);
}
