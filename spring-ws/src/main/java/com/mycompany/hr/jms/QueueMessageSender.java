package com.mycompany.hr.jms;

import org.springframework.jms.core.MessageCreator;

public interface QueueMessageSender {

	void sendMessage(MessageCreator messageCreator);
}
