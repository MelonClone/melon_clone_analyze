package com.devgd.mq.analyzer.domain.rabbitmq.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.devgd.mq.analyzer.domain.model.BaseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "user_playtime_table")
@NoArgsConstructor
public class UserPlaytimeEntity implements Serializable, BaseEntity {
	// TODO
	/**
	 *
	 */
	private static final long serialVersionUID = 6041965711529517253L;

	@Id
	@Column(name = "user_id")
	private Integer userId;

	@Builder
	public UserPlaytimeEntity(Integer userId) {
		this.userId = userId;
	}
}