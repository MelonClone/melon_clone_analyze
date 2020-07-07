package com.devgd.mq.analyzer.domain.message.api;

import com.devgd.mq.analyzer.domain.message.application.MessageService;
import com.devgd.mq.analyzer.domain.model.BaseDto;
import com.devgd.mq.analyzer.domain.playtime.dto.PlaytimeDto;
import com.devgd.mq.analyzer.domain.search.dto.SearchDto;
import com.devgd.mq.analyzer.global.common.Constants;
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

	@PostMapping("/playtime")
	public SuccessResponse sendPlaytimeMessage(
		@RequestBody final PlaytimeDto playtimeDto
	) {
		messageService.sendMessage(Constants.PLAYTIME_ROUTING_KEY, (BaseDto) playtimeDto);
		return new SuccessResponse("done");
	}
	
	@PostMapping("/search")
	public SuccessResponse sendSearchMessage(
		@RequestBody final SearchDto searchDto
	) {
		messageService.sendMessage(Constants.SEARCH_ROUTING_KEY, (BaseDto) searchDto);
		return new SuccessResponse("done");
	}
	
}