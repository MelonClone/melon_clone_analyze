package com.devgd.mq.analyzer.domain.rabbitmq.api;

import com.devgd.mq.analyzer.global.common.Constants;

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
			System.out.println(rabbitTemplate.getConnectionFactory().getHost());
			System.out.println(rabbitTemplate.getConnectionFactory().getPort());
			System.out.println(rabbitTemplate.getExchange());
			System.out.println(rabbitTemplate.getRoutingKey());
			this.rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, Constants.ROUTING_KEY, message);
		} catch (AmqpException e) {
			System.out.println("AMQPException");
			System.out.println(e.toString());
		}
	}
}