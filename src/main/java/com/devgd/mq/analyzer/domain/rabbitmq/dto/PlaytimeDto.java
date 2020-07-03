package com.devgd.mq.analyzer.domain.rabbitmq.dto;

import com.devgd.mq.analyzer.domain.model.BaseDto;
import com.devgd.mq.analyzer.domain.rabbitmq.domain.UserPlaytimeEntity;
import com.devgd.mq.analyzer.global.common.util.ModelMapperUtils;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PlaytimeDto implements BaseDto<UserPlaytimeEntity> {
	// music id
	// user id
	// playtime
	// user_playtime
	// category
	// timestamp
	// is_listen_all
	// is_select_seekbar
// TODO
	@Builder
	public PlaytimeDto(int a) {}

	@Override
	public UserPlaytimeEntity toEntity(){
		return null;
	}

	@Override
	public PlaytimeDto parse(UserPlaytimeEntity userEntity) {
		ModelMapperUtils.getModelMapper().map(userEntity, this);

		return this;
	}
}