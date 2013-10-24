package com.training.neo4j.dao.entities;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Person extends BaseEntity {

	public static final String BEST_FRIEND_REL = "BEST_FRIEND_WITH";
	public static final String FRIEND_REL = "FRIEND_WITH";
	
	@GraphProperty
	private String name;
	@GraphProperty
	private String lastName;
	@RelatedTo(direction=Direction.OUTGOING, type=BEST_FRIEND_REL)
	private Person bestFriend;
	@RelatedTo(direction=Direction.BOTH, type=FRIEND_REL)
	private Set<Person> friends;
	@RelatedTo(direction=Direction.OUTGOING, type=Country.COUNTRY_REL)
	private Country country;
	
	/* Constructors */
	public Person() {
	}
	public Person(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	/* Setters and getters */
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
	public Person getBestFriend() {
		return bestFriend;
	}
	public void setBestFriend(Person bestFriend) {
		this.bestFriend = bestFriend;
	}
	public Set<Person> getFriends() {
		return friends;
	}
	public void setFriends(Set<Person> friends) {
		this.friends = friends;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public void addFriend(Person friend){
		if(friends == null){
			friends = new HashSet<Person>();
		}
		friends.add(friend);
	}
}
