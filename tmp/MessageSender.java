package com.devgd.mq.analyzer.domain.message.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);
	

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendTo(String routingKey, String message) {
		logger.info("MQ Send message....");
		System.out.println("MQ Send message....");
		try {
			this.rabbitTemplate.convertAndSend(routingKey, message);
		} catch (AmqpException e) {
			System.out.println("AMQPException");
			System.out.println(e.toString());
		}
	}
}