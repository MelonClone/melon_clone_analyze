package com.devgd.mq.analyzer.global.common.response;

import lombok.Getter;

@Getter
public class SuccessResponse {
	private String msg = "success";

	public SuccessResponse(String message) {
		this.msg = message;
	}
}