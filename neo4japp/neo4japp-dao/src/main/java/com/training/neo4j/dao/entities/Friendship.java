package com.training.neo4j.dao.entities;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import com.training.neo4j.dao.entities.location.Country;

@NodeEntity
public class Friendship extends Person {

	public static final String BEST_FRIEND_REL = "BEST_FRIEND_WITH";
	public static final String FRIEND_REL = "FRIEND_WITH";
	
	@RelatedTo(direction=Direction.OUTGOING, type=BEST_FRIEND_REL)
	private Friendship bestFriend;
	@RelatedTo(direction=Direction.BOTH, type=FRIEND_REL)
	private Set<Friendship> friends;
	@RelatedTo(direction=Direction.OUTGOING, type=Country.COUNTRY_REL)
	private Country country;
	
	/* Constructors */
	public Friendship() {
		super();
	}
	public Friendship(String name, String lastName) {
		super(name, lastName);
	}
	public Friendship(String name, String lastName, String email) {
		super(name, lastName, email);
	}
	/* Setters and getters */
	public Friendship getBestFriend() {
		return bestFriend;
	}
	public void setBestFriend(Friendship bestFriend) {
		this.bestFriend = bestFriend;
	}
	public Set<Friendship> getFriends() {
		return friends;
	}
	public void setFriends(Set<Friendship> friends) {
		this.friends = friends;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public void addFriend(Friendship friend){
		if(friends == null){
			friends = new HashSet<Friendship>();
		}
		friends.add(friend);
	}
}
