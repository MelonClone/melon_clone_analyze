package com.devgd.mq.analyzer.global.config;

import com.devgd.mq.analyzer.domain.rabbitmq.api.AMessageReceiver;
import com.devgd.mq.analyzer.global.common.Constants;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConf {
	
	@Bean
	Queue queue() {
		return new Queue(Constants.QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(Constants.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding binding(@Qualifier("queue") Queue queue, @Qualifier("exchange") TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Constants.ROUTING_KEY);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(Constants.QUEUE_NAME);
		// container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(AMessageReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
}
