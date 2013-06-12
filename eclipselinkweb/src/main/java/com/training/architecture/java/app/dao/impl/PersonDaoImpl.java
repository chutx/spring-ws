package com.training.architecture.java.app.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.training.architecture.java.app.dao.PersonDao;
import com.training.architecture.java.app.dao.entities.PersonPO;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persistPerson(PersonPO personPO) {
		entityManager.persist(personPO);
	}

}
