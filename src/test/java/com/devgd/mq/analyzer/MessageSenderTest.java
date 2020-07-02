package com.devgd.mq.analyzer;

import com.devgd.mq.analyzer.domain.rabbitmq.api.MessageSender;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageSenderTest {

	@Autowired
	private MessageSender messageSender;
	
	@Test
	public void testSendMsg() {
		
		messageSender.sendTo("foo.bar.#", "MYMESSAGE");
	}
	
}