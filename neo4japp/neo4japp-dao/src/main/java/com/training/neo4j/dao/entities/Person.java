package com.training.neo4j.dao.entities;

import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Person extends BaseEntity {

	@GraphProperty
	private String name;
	@GraphProperty
	private String lastName;
	@Indexed(indexName="email", unique=true)
	private String email;
	
	public Person() { }
	public Person(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	
	public Person(String name, String lastName, String email) {
		this(name, lastName);
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
