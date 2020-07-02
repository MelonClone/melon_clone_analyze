package com.devgd.mq.analyzer.domain.rabbitmq.receiver;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AMessageReceiver {
	
	private static final Logger logger = LoggerFactory.getLogger(AMessageReceiver.class);
	
	/* 
	@RabbitListener(
		bindings = @QueueBinding(
			key = Constants.ROUTING_KEY,
			value = @Queue(Constants.QUEUE_NAME),
			exchange = @Exchange(
				value = Constants.TOPIC_EXCHANGE_NAME, 
				type = "topic", 
				durable = "true"
			)
		)
	)
	public void onMessage(Message message) {
		logger.info(String.format("Received < %s >", message.toString()));
	}
	 */
	
	private CountDownLatch latch = new CountDownLatch(1);
	
	public void receiveMessage(String message) {
		logger.info(String.format("Received < %s >", message.toString()));
		latch.countDown();
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}
}