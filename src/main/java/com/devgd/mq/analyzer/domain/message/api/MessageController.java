package com.devgd.mq.analyzer.domain.message.api;

import java.util.Map;

import com.devgd.mq.analyzer.domain.message.application.MessageService;
import com.devgd.mq.analyzer.global.common.response.SuccessResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("message")
@RequestMapping("/v1/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;

	@PostMapping()
	public SuccessResponse sendMessage(
		@RequestBody Map<String, String> messageJson
	) {
		messageService.sendMessage(messageJson);
		return new SuccessResponse("done");
	}
	
}