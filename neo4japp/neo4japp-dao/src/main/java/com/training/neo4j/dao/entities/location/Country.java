package com.training.neo4j.dao.entities.location;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.training.neo4j.dao.entities.BaseEntity;
import com.training.neo4j.dao.entities.Friendship;

@NodeEntity
public class Country extends BaseEntity {

	public static final String COUNTRY_REL = "FROM_COUNTRY";
	
	@GraphProperty
	private String name;
	@RelatedTo(direction=Direction.INCOMING, type=COUNTRY_REL)
	private Iterable<Friendship> people;
	
	public Country() {
	}
	public Country(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Iterable<Friendship> getPeople() {
		return people;
	}
	public void setPeople(Iterable<Friendship> people) {
		this.people = people;
	}
	
}
