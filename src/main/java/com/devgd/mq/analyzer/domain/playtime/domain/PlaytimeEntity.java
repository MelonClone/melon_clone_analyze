package com.devgd.mq.analyzer.domain.playtime.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class PlaytimeEntity implements Serializable, BaseEntity {
	// TODO

	/**
	 *
	 */
	private static final long serialVersionUID = 1545952149327453207L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "user_playtime_id", nullable = false)
	private Integer userPlaytimeId;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(name = "music_id", nullable = false)
	private String musicId;

	@Column(name = "playtime", nullable = false)
	private Integer playtime;

	@Column(name = "background_playtime", nullable = false)
	private Integer backgroundPlaytime;
	
	@Column(name = " user_playtime", nullable = false)
	private Integer userPlaytime;

	@Column(name = "category", nullable = false)
	private Integer category;

	@Column(name = "timestamp", nullable = false)
	private LocalDateTime timestamp;

	@Column(name = "is_listen_all", nullable = false)
	private Boolean isListenAll;

	@Column(name = "is_select_seekbar", nullable = false)
	private Boolean isSelectSeekbar;

	@Builder
	public PlaytimeEntity(Integer userPlaytimeId, Integer userId, String musicId, Integer playtime, 
			Integer userPlaytime, Integer category, LocalDateTime timestamp, 
			Boolean isListenAll, Boolean isSelectSeekbar) {
		this.userPlaytimeId = userPlaytimeId;
		this.userId = userId;
		this.musicId = musicId;
		this.playtime = playtime;
		this.userPlaytime = userPlaytime;
		this.category = category;
		this.timestamp = timestamp;
		this.isListenAll = isListenAll;
		this.isSelectSeekbar = isSelectSeekbar;
	}
}