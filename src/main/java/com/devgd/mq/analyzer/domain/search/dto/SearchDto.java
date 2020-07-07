package com.devgd.mq.analyzer.domain.search.dto;

import com.devgd.mq.analyzer.domain.model.BaseDto;
import com.devgd.mq.analyzer.domain.playtime.domain.PlaytimeEntity;
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
public class SearchDto implements BaseDto<PlaytimeEntity> {
	// music id
	private Integer userId;

	// TODO
	@Builder
	public SearchDto(Integer userId) {
		this.userId = userId;
	}

	@Override
	public PlaytimeEntity toEntity(){
		return null;
	}

	@Override
	public SearchDto parse(PlaytimeEntity userEntity) {
		ModelMapperUtils.getModelMapper().map(userEntity, this);

		return this;
	}
}