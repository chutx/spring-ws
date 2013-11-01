package com.training.neo4j.dao.entities.filmography;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity
public class Role {

	@StartNode
	private Actor actor;
	@EndNode
	private Movie movie;
	
	private String name;

	public Role() { }
	public Role(Actor actor, Movie movie, String name) {
		super();
		this.actor = actor;
		this.movie = movie;
		this.name = name;
	}

	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
