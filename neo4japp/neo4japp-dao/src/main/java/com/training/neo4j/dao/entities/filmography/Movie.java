package com.training.neo4j.dao.entities.filmography;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.training.neo4j.dao.entities.BaseEntity;

@NodeEntity
public class Movie extends BaseEntity {

	@GraphProperty
	private String name;
	
	private String year;
	
	@RelatedToVia(direction=Direction.INCOMING, type="ACTS_IN")
	private Iterable<Role> roles;

	public Movie() {
		super();
	}
	public Movie(String name, String year) {
		super();
		this.name = name;
		this.year = year;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Iterable<Role> getRoles() {
		return roles;
	}
	public void setRoles(Iterable<Role> roles) {
		this.roles = roles;
	}
	
}
