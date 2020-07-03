package com.devgd.mq.analyzer.domain.rabbitmq.dto;

import java.time.LocalDateTime;

import com.devgd.mq.analyzer.domain.model.BaseDto;
import com.devgd.mq.analyzer.domain.rabbitmq.domain.UserEntity;
import com.devgd.mq.analyzer.domain.rabbitmq.domain.UserEntity.UserEntityBuilder;
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
public class UserDto implements BaseDto<UserEntity> {
	private Integer userId;
	private String nickname;
	private String email;
	private String password;
	private LocalDateTime createDate = LocalDateTime.now();
	private LocalDateTime lastLogin;
	private Boolean activate = true;
	private LocalDateTime disableDate;

	@Builder
	public UserDto(Integer userId, String email, String password) {
		this.userId = userId;
		this.email = email;
		this.password = password;
	}

	@Override
	public UserEntity toEntity(){
		UserEntityBuilder userEntityBuilder = UserEntity.builder()
				.userId(userId)
				.nickname(nickname)
				.email(email)
				.password(password)
				.createDate(createDate)
				.lastLogin(lastLogin)
				.activate(activate)
				.disableDate(disableDate);
		return userEntityBuilder.build();
	}

	@Override
	public UserDto parse(UserEntity userEntity) {
		ModelMapperUtils.getModelMapper().map(userEntity, this);

		return this;
	}
}