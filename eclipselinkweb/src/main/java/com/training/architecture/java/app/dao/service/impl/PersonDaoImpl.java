package com.training.architecture.java.app.dao.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.training.architecture.java.app.dao.entities.PersonPO;
import com.training.architecture.java.app.dao.service.PersonDao;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	private final static Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persistPerson(PersonPO personPO) {
		logger.debug("Persisting ....." + personPO);
		entityManager.persist(personPO);
	}

	public PersonPO fetchPerson(Long id) {
		return entityManager.find(PersonPO.class, id);
	}

}
