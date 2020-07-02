package com.devgd.mq.analyzer.domain.message.receiver;

import com.devgd.mq.analyzer.global.common.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AMessageReceiver {
	
	private static final Logger logger = LoggerFactory.getLogger(AMessageReceiver.class);

	
	@RabbitListener(
		bindings = @QueueBinding(
			key = "test",
			value = @Queue,
			exchange = @Exchange(
				value = "test-topic", 
				type = "topic", 
				durable = "true"
			)
		)
	)
	// @RabbitListener(queues = Constants.QUEUE_NAME)
	public void onMessage(Message message) {
		logger.info(String.format("Received < %s >", message.toString()));
	}
	

	@RabbitListener(queues = Constants.QUEUE_NAME)
	public void receiveMessage(Message message) {
		logger.info(String.format("Received < %s >", message.toString()));
		System.out.println("A");
		System.out.println(message);
	}

	// @RabbitListener(queues = RabbitMQConfiguration.queueName)
	// public void receiveMessage2(Message message) {
	// 	System.out.println("B");
	// 	System.out.println(new String(message.getBody()));
	// }
}