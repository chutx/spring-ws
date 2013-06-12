package com.training.architecture.java.springwebapp.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.architecture.java.springwebapp.business.BusinessClass;
import com.training.architecture.java.springwebapp.dao.PersonDao;
import com.training.architecture.java.springwebapp.domain.Person;
import com.training.architecture.java.springwebapp.entities.PersonPO;
import com.training.architecture.java.springwebapp.transformers.PersonTransformer;

@Service("businessClass")
@Transactional
public class BusinessClassImpl implements BusinessClass {

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private PersonTransformer personTransformer;
	
	@Transactional
	public String sayHello(Long id) {
		PersonPO person = personDao.fetchPerson(id); 
		return person.getName();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void savePerson(Person person) {
		PersonPO po = (PersonPO) personTransformer.transform(person);
		personDao.addPerson(po);
		
		personDao.fetchPersonList(1, 10);
	}

	public void updatePerson(Person person, Long id) {
		// TODO Auto-generated method stub
		
	}

}
