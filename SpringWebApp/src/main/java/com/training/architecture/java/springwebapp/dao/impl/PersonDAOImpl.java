package com.training.architecture.java.springwebapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.architecture.java.springwebapp.dao.PersonDao;
import com.training.architecture.java.springwebapp.entities.PersonPO;

@Repository
public class PersonDAOImpl implements PersonDao {

	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	
    @Transactional
	public void addPerson(PersonPO person) {
		getEntityManager().persist(person);
	}

	public void updatePerson(PersonPO person) {
		entityManager.merge(person);
	}

	public PersonPO fetchPerson(Long id) {
		return entityManager.find(PersonPO.class, id);
	}

	public List<PersonPO> fetchPersonList(Integer page, Integer numOfRecords) {
		Query query = entityManager.createQuery("select p from Person p");
		query.setFirstResult((page-1) * numOfRecords).setMaxResults(numOfRecords);
		query.getResultList();
		return null;
	}

}
