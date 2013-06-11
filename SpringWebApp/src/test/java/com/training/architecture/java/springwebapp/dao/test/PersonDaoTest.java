package com.training.architecture.java.springwebapp.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.training.architecture.java.springwebapp.dao.PersonDao;
import com.training.architecture.java.springwebapp.entities.PersonPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:META-INF/spring/orm-context.xml",
		"classpath:META-INF/spring/dao-context.xml"
		})
// AbstractTransactionalJUnit4SpringContextTests
public class PersonDaoTest {
	
	@Autowired
	private PersonDao personDao;
	
	private Long id = 1L;

	@Test
	public void fetchPersonTest(){
		Long id = 1L;
		personDao.fetchPerson(id);
	}
	
	@Test
	@Transactional
	public void addPersonTest(){
		PersonPO person = createPerson("angel", "Rodriguez");
		personDao.addPerson(person);
		person = createPerson("firstName", "lastName");
		personDao.addPerson(person);
		
		List<PersonPO> list = personDao.fetchPersonList(1, 10);
		list.size();
	}
	
	private PersonPO createPerson(String firstName, String lastName){
		PersonPO person = new PersonPO();
		person.setLastName(lastName);
		person.setName(firstName);
//		person.setId(id++);
		return person;
	}
}
