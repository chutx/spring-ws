package com.training.neo4j.config.test;

import javax.transaction.TransactionManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={
		"classpath:META-INF/spring/tx-context-test.xml"
})
@TransactionConfiguration(defaultRollback=true, transactionManager="neo4jTransactionManager")
@ActiveProfiles(value={"test"})
public class TxManagerTest {

	@Autowired
	private JtaTransactionManager neo4jTransactionManager;
	
	@Autowired
	private Neo4jTemplate neo4jTemplate; 
	
	@Test
	public void txTest(){
		TransactionManager tx = neo4jTransactionManager.getTransactionManager();
		
		Assert.assertNotNull(tx);
	}
	
	@Test
	@Transactional
	public void templateTest(){
		Node node = neo4jTemplate.createNode();
		Assert.assertNotNull(node);
	}
	
	
}
