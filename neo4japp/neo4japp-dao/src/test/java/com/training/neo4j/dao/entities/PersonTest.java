package com.training.neo4j.dao.entities;

import java.util.Collection;
import java.util.Iterator;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:META-INF/spring/tx-context-test.xml"
})
@TransactionConfiguration(transactionManager="neo4jTransactionManager", defaultRollback=true)
@ActiveProfiles("test")
public class PersonTest {

	@Autowired
	private Neo4jTemplate neo4jTemplate;
	
	@Test
	@Transactional
	@Rollback
	public void saveSinglePerson(){
		Person person = new Person("name", "lastname");
		Person result = neo4jTemplate.save(person);
		
		assertNodeIdNotZero(result);
	}
	
	@Test
	@Transactional
	@Rollback
	 public void savePersonWithBestFriend(){
	  Person person = new Person("Juan", "Perez");
	  person.setBestFriend(new Person("Jose", "Garcia"));
	  
	  Person result = neo4jTemplate.save(person);
	  
	  assertNodeIdNotZero(result);
	  assertNodeIdNotZero(result.getBestFriend());
	 }
	
	@Test
	@Transactional
	@Rollback
	 public void savePersonWithListOfFriends(){
	  Person person = new Person("Juan", "Perez");
	  person.setBestFriend(new Person("Jose", "Garcia"));
	  person.addFriend(new Person("Pedro", "Almodovar"));
	  
	  Person result = neo4jTemplate.save(person);
	  
	  assertNodeIdNotZero(result);
	  assertThatPeopleHasId(result.getFriends());
	 }
	
	private void assertNodeIdNotZero(BaseEntity entity){
		Assert.assertThat(entity.getNodeId(), CoreMatchers.is(CoreMatchers.not(0L)));
	}
	
	private void assertThatPeopleHasId(Collection<Person> people) {
		Iterator<Person> friends = people.iterator();
		while (friends.hasNext()) {
			Person friend = friends.next();
			assertNodeIdNotZero(friend);
		}
	}
}
