package com.training.architecture.java.springwebapp.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.training.architecture.java.springwebapp.dao.PersonDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:META-INF/spring/orm-context.xml",
		"classpath:META-INF/spring/dao-context.xml"
		})
// AbstractTransactionalJUnit4SpringContextTests
public class PersonDaoTest {
	
	@Autowired
	private PersonDao personDao;

	@Test
	public void fetchNameTest(){
		personDao.fetchName(1L);
	}
}
