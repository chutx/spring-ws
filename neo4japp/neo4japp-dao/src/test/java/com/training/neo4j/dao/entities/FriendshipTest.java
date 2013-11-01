package com.training.neo4j.dao.entities;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
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
public class FriendshipTest extends PersonTest {

	@Autowired
	private Neo4jTemplate neo4jTemplate;
	
	@Test
	@Transactional
	 public void savePersonWithBestFriend(){
	  Friendship person = new Friendship("Juan", "Perez", getEmail());
	  person.setBestFriend(new Friendship("Jose", "Garcia", getEmail()));
	  
	  Friendship result = neo4jTemplate.save(person);
	  
	  assertNodeIdNotZero(result);
	  assertNodeIdNotZero(result.getBestFriend());
	 }
	
	@Test
	@Transactional
	 public void savePersonWithListOfFriends(){
	  Friendship person = new Friendship("Juan", "Perez", getEmail());
	  person.setBestFriend(new Friendship("Jose", "Garcia", getEmail()));
	  person.addFriend(new Friendship("Pedro", "Almodovar", getEmail()));
	  
	  Friendship result = neo4jTemplate.save(person);
	  
	  assertNodeIdNotZero(result);
	  assertThatPeopleHasId(result.getFriends());
	 }
	
	private void assertThatPeopleHasId(Collection<Friendship> people) {
		Iterator<Friendship> friends = people.iterator();
		while (friends.hasNext()) {
			Friendship friend = friends.next();
			assertNodeIdNotZero(friend);
		}
	}

}
