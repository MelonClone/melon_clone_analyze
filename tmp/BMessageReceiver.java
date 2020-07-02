package com.devgd.mq.analyzer.domain.message.receiver;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

@Component
public class BMessageReceiver {

	private CountDownLatch latch = new CountDownLatch(1);
	
	public void receiveMessage(String message) {
		System.out.println("Received < " + message + ">");
		latch.countDown();
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}
}