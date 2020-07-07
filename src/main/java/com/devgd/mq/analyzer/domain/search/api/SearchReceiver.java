package com.devgd.mq.analyzer.domain.search.api;

import com.devgd.mq.analyzer.domain.playtime.application.PlaytimeService;
import com.devgd.mq.analyzer.domain.search.dto.SearchDto;
import com.devgd.mq.analyzer.global.common.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchReceiver {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchReceiver.class);
	
	@Autowired
	PlaytimeService playtimeService;

	@RabbitListener(
		bindings = @QueueBinding(
			key = Constants.SEARCH_ROUTING_KEY,
			value = @Queue(
				value = Constants.SEARCH_QUEUE_NAME, 
				durable="true"),
			exchange = @Exchange(
				value = Constants.TOPIC_EXCHANGE_NAME, 
				ignoreDeclarationExceptions = "true",
				type = "topic",	
				durable = "true"))) 
	public void onSearchMessage(SearchDto searchDto) {
		logger.info(String.format("Search Received < %s >", searchDto.toString()));
	}
}