package com.training.architecture.java.app.business.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.training.architecture.java.app.business.service.PersonService;
import com.training.architecture.java.app.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:META-INF/spring/orm-context-test.xml",
		"classpath:META-INF/spring/dao-context.xml",
		"classpath:META-INF/spring/business-context.xml"
		})
@TransactionConfiguration(defaultRollback=true)
public class PersonServiceTest {

	@Autowired
	private PersonService personService;
	
	@Test
	public void saveTest(){
		Person person = new Person();
		person.setFirstName("firstName");
		person.setLastName("lastName");
		personService.savePerson(person);
	}
	
	@Test
	public void fetchPersonTest(){
		Person result = personService.getPerson(1l);
		Assert.assertNotNull(result);
	}
}
