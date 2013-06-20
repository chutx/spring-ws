package com.mycompany.hr.jms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.mycompany.hr.jms.PublisherJms;
import com.mycompany.hr.jms.QueueMessageSender;

@Service
public class PublisherJmsImpl implements PublisherJms {

	@Autowired
	private QueueMessageSender messageSender;
	
	public void publishMessage(String message) {
		MessageCreator messageCreator = new QueueMessageCreatorImpl(message);
		messageSender.sendMessage(messageCreator);
	}

}
