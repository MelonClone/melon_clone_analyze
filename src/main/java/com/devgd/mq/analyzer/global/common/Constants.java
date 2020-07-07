package com.devgd.mq.analyzer.global.common;

public class Constants {
	public static final String QUEUE_NAME_PREFIX = "spring";
	public static final String SEARCH_QUEUE_NAME = QUEUE_NAME_PREFIX+".search";
	public static final String PLAYTIME_QUEUE_NAME = QUEUE_NAME_PREFIX+".playtime";
	public static final String TOPIC_EXCHANGE_NAME = QUEUE_NAME_PREFIX + "-exchange";
	public static final String PLAYTIME_ROUTING_KEY = "playtime.#";
	public static final String SEARCH_ROUTING_KEY = "search.#";
	
}