package com.devgd.mq.analyzer.domain.playtime.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.devgd.mq.analyzer.domain.model.BaseDto;
import com.devgd.mq.analyzer.domain.playtime.domain.PlaytimeEntity;
import com.devgd.mq.analyzer.global.common.util.ModelMapperUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlaytimeDto implements BaseDto<PlaytimeEntity>, Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 8883231059258685266L;

	private Integer userId;
	private String musicId;
	private Integer playtime = 0;
	private Integer userPlaytime = 0;
	private Integer category;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime timestamp = LocalDateTime.now();
	private Boolean isListenAll = false;
	private Boolean isSelectSeekbar = false;

	// TODO
	@Builder
	public PlaytimeDto(Integer userId, String musicId, Integer playtime, 
		Integer userPlaytime, Integer category, LocalDateTime timestamp, 
		Boolean isListenAll, Boolean isSelectSeekbar) {
		this.userId = userId;
		this.musicId = musicId;
		this.playtime = playtime;
		this.userPlaytime = userPlaytime;
		this.category = category;
		this.timestamp = timestamp;
		this.isListenAll = isListenAll;
		this.isSelectSeekbar = isSelectSeekbar;
	}

	@Override
	public PlaytimeEntity toEntity(){
		return PlaytimeEntity.builder()
			.userId(userId)
			.musicId(musicId)
			.playtime(playtime)
			.userPlaytime(userPlaytime)
			.category(category)
			.timestamp(timestamp)
			.isListenAll(isListenAll)
			.isSelectSeekbar(isSelectSeekbar)
			.build();
	}

	@Override
	public PlaytimeDto parse(PlaytimeEntity userEntity) {
		ModelMapperUtils.getModelMapper().map(userEntity, this);

		return this;
	}
}