package com.training.architecture.java.app.dao.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.training.architecture.java.app.dao.entities.PersonPO;
import com.training.architecture.java.app.dao.service.PersonDao;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void persistPerson(PersonPO personPO) {
		entityManager.persist(personPO);
	}

	public PersonPO fetchPerson(Long id) {
		return entityManager.find(PersonPO.class, id);
	}

}
