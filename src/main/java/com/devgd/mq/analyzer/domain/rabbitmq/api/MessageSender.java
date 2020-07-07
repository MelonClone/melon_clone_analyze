package com.devgd.mq.analyzer.domain.rabbitmq.api;

import com.devgd.mq.analyzer.domain.model.BaseDto;
import com.devgd.mq.analyzer.domain.model.BaseEntity;
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
		try {
			this.rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, routingKey, message);
		} catch (AmqpException e) {
			logger.error("AMQPException", e);
		}
	}

	public void sendTo(String routingKey, BaseDto<BaseEntity> message) {
		logger.info("MQ Send message....");
		try {
			this.rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE_NAME, routingKey, message);
		} catch (AmqpException e) {
			logger.error("AMQPException", e);
		}
	}
}