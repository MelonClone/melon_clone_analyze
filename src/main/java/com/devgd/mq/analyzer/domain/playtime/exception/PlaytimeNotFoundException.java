package com.devgd.mq.analyzer.domain.playtime.exception;

import com.devgd.mq.analyzer.global.error.GlobalNotFoundException;

public class PlaytimeNotFoundException extends GlobalNotFoundException {

	/**
	 *
	 */
	private static final long serialVersionUID = 5669413369326551718L;

	public PlaytimeNotFoundException(String target) {
		super("User "+target + " is not found");
	}
	
}