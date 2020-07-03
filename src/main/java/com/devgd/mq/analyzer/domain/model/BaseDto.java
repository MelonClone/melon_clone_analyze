package com.devgd.mq.analyzer.domain.model;

public interface BaseDto<T extends BaseEntity> {
	T toEntity();
	BaseDto<T> parse(T t);
}