package com.training.neo4j.business.service;

import java.util.Set;

import com.training.neo4j.dao.entities.location.Country;

public interface CountryService {

	Set<Country> getAllCountries();
	
}
