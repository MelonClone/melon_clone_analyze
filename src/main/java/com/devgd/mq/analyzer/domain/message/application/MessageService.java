package com.devgd.mq.analyzer.domain.message.application;

import java.util.Map;

import com.devgd.mq.analyzer.domain.model.BaseDto;
import com.devgd.mq.analyzer.domain.model.BaseEntity;
import com.devgd.mq.analyzer.domain.rabbitmq.api.MessageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MessageService {
	
	@Autowired
	MessageSender messageSender;

	public void sendMessage(String routingKey, String message) {
		messageSender.sendTo(routingKey, message);
	}

	public void sendMessage(String routingKey, BaseDto<BaseEntity> message) {
		messageSender.sendTo(routingKey, message);
	}

	public void sendMessage(String routingKey, Map<String, String> message) {
		messageSender.sendTo(routingKey, flat(message));
	}

	public String flat(Map<String, String> object) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (String key : object.keySet()) {
			sb.append("\"");
			sb.append(key);
			sb.append("\":\"");
			sb.append(object.get(key));
			sb.append("\"");
			sb.append(",");
		}
		if (sb.length() > 1) sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(",")+1);
		sb.append("}");
		return sb.toString();
	}
}