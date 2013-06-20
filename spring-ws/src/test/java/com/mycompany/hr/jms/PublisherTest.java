package com.mycompany.hr.jms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath:META-INF/spring/jms-context-test.xml"
})
public class PublisherTest {

	@Autowired
	private PublisherJms publisherJms;
	
	@Test
	public void testConfig(){
		Assert.assertTrue(true);
	}
	
	@Test
	public void sendMessageTest(){
		publisherJms.publishMessage("Test message");
	}
}
