package com.mycompany.hr.jms.impl;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.mycompany.hr.jms.QueueMessageSender;

@Component("queueMessageSender")
public class QueueMessageSenderImpl implements QueueMessageSender{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queueDestination;
	
	private static Logger logger = LoggerFactory.getLogger(QueueMessageSenderImpl.class);
	
	public void sendMessage(MessageCreator messageCreator) {
		logger.info("Sending message");
		jmsTemplate.send(queueDestination, messageCreator);
	}

}
