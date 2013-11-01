package com.training.neo4j.dao.entities.filmography;

import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.training.neo4j.dao.entities.Person;

@NodeEntity
public class Actor extends Person {

	@RelatedToVia(direction=Direction.OUTGOING, type="ACTS_IN")
	private Set<Role> roles;
	
	public Actor() {
		super();
	}
}
