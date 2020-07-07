package com.devgd.mq.analyzer.domain.playtime.api;

import com.devgd.mq.analyzer.domain.playtime.application.PlaytimeService;
import com.devgd.mq.analyzer.domain.playtime.dto.PlaytimeDto;
import com.devgd.mq.analyzer.global.common.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaytimeReceiver {
	
	private static final Logger logger = LoggerFactory.getLogger(PlaytimeReceiver.class);
	
	@Autowired
	PlaytimeService playtimeService;

	@RabbitListener(
		bindings = @QueueBinding(
			key = Constants.PLAYTIME_ROUTING_KEY,
			value = @Queue(
				value = Constants.PLAYTIME_QUEUE_NAME,
				durable = "true"),
			exchange = @Exchange(
				value = Constants.TOPIC_EXCHANGE_NAME, 
				type = "topic",
				durable = "true")))
	public void onPlaytimeMessage(PlaytimeDto playtimeDto, Message message) {
		if (message != null)
			logger.info(message.toString());
		logger.info(String.format("Playtime Received < %s >", playtimeDto.toString()));
		// message.getMessageProperties().
		try { 
			playtimeService.addUserPlaytime(playtimeDto);
		} catch(Exception e) {

		}
	}
}