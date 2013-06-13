package com.training.architecture.java.app.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.architecture.java.app.dao.entities.PersonPO;
import com.training.architecture.java.app.dao.service.PersonDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:META-INF/spring/orm-context-test.xml",
		"classpath:META-INF/spring/dao-context.xml"
		})
// AbstractTransactionalJUnit4SpringContextTests
@TransactionConfiguration(defaultRollback=true)
public class PersonDaoTest {
	
	@Autowired
	private PersonDao personDao;
	
	@Test
	@Transactional(propagation=Propagation.REQUIRED)
	public void persistTest(){
		PersonPO person = createPerson("angel", "Rodriguez");
		personDao.persistPerson(person);
		person = createPerson("firstName", "lastName");
	}
	
	private PersonPO createPerson(String firstName, String lastName){
		PersonPO person = new PersonPO();
		person.setLastName(lastName);
		person.setFirstName(firstName);
		return person;
	}
	
}