package com.training.neo4j.dao.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.training.neo4j.dao.entities.Friendship;

public interface PersonRepository extends GraphRepository<Friendship> {

}
