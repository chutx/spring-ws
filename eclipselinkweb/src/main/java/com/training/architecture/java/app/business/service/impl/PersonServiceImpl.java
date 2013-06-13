package com.training.architecture.java.app.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.architecture.java.app.business.service.PersonService;
import com.training.architecture.java.app.dao.entities.PersonPO;
import com.training.architecture.java.app.dao.service.PersonDao;
import com.training.architecture.java.app.domain.Person;
import com.training.architecture.java.app.util.transformers.PersonTransformer;

@Service("personService")
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private PersonTransformer personTransformer;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void savePerson(Person person) {
		PersonPO po = (PersonPO)personTransformer.transform(person);
		personDao.persistPerson(po);
	}

	public Person getPerson(Long id) {
		PersonPO po = personDao.fetchPerson(id);
		Person result =  (Person)personTransformer.transform(po);
		return result;
		
	}

	public List<Person> getPeople() {
		// TODO Auto-generated method stub
		return null;
	}

}
