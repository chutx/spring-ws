package com.mycompany.hr.jms.impl;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.MessageCreator;

public class QueueMessageCreatorImpl implements MessageCreator {

	private static Logger logger = LoggerFactory.getLogger(QueueMessageCreatorImpl.class);
	private String text;
	
	public QueueMessageCreatorImpl(){
		
	}
	
	public QueueMessageCreatorImpl(String text) {
		this.text = text;
	}
	
	public Message createMessage(Session session) throws JMSException {
		String text = this.toString();
		logger.debug("JmsSimpleMessageCreator : Created New Messsage: " + text);
		TextMessage message = session.createTextMessage(text);
		
		String correlationId = this.createRandomString();
		message.setJMSCorrelationID(correlationId);
		return message;
	}

	public void setText(String text) {
		this.text = text;
	}

	private String createRandomString() {
		return UUID.randomUUID().toString();
	}

	@Override
	public String toString() {
		return this.text;
	}
}
