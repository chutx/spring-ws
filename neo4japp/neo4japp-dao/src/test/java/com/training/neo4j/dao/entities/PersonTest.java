package com.training.neo4j.dao.entities;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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
public class PersonTest {

	@Autowired
	private Neo4jTemplate neo4jTemplate;
	
	private static Integer counter;
	
	static{
		counter = 0;
	}
	
	@Test
	@Transactional
	public void saveSinglePerson(){
		Person person = new Person("name", "lastname", getEmail());
		Person result = neo4jTemplate.save(person);
		
		assertNodeIdNotZero(result);
	}
	
	protected void assertNodeIdNotZero(BaseEntity entity){
		Assert.assertThat(entity.getNodeId(), CoreMatchers.is(CoreMatchers.not(0L)));
	}
	
	protected String getEmail(){
		return "" + counter++ +"@email";
	}
}
