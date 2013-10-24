package com.training.neo4j.dao.entities;

import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Country extends BaseEntity {

	@GraphProperty
	private String name;

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
	
}
