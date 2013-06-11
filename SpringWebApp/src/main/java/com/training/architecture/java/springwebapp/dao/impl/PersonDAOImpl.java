package com.training.architecture.java.springwebapp.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.training.architecture.java.springwebapp.dao.PersonDao;
import com.training.architecture.java.springwebapp.domain.Person;

@Repository
public class PersonDAOImpl implements PersonDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public String fetchName(Long id){
		Person person = entityManager.find(Person.class, id);
		return "starting";
	}

}
