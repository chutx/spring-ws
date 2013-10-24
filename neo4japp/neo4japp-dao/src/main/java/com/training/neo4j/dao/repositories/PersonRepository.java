package com.training.neo4j.dao.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.training.neo4j.dao.entities.Person;

public interface PersonRepository extends GraphRepository<Person> {

}
