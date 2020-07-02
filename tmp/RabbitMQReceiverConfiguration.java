package com.devgd.mq.analyzer.global.config;

import com.devgd.mq.analyzer.global.common.Constants;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQReceiverConfiguration {
	
	@Bean
	public Queue aaqueue() {
		// return new Queue(Constants.QUEUE_NAME);
		return QueueBuilder.nonDurable(Constants.QUEUE_NAME).build();
	}

	@Bean
	public TopicExchange topicExchange() {
		return ExchangeBuilder.topicExchange(Constants.TOPIC_EXCHANGE_NAME).build();
	}

	@Bean
	public Binding abinding(@Qualifier("aaqueue") Queue aaqueue, @Qualifier("topicExchange") TopicExchange topicExchange) {
		return BindingBuilder.bind(aaqueue).to(topicExchange).with(Constants.QUEUE_NAME);
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}
}