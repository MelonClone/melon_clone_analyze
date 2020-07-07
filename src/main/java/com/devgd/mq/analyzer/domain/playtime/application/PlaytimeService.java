package com.devgd.mq.analyzer.domain.playtime.application;

import com.devgd.mq.analyzer.domain.playtime.dao.PlaytimeDao;
import com.devgd.mq.analyzer.domain.playtime.dto.PlaytimeDto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlaytimeService {
	
	private final PlaytimeDao playtimeDao;
	
	public void addUserPlaytime(PlaytimeDto playtimeDto) {
		// TODO Playtime record
		// music id
		// user id
		// playtime
		// user_playtime
		// category
		// timestamp
		// is_listen_all
		// is_select_seekbar
		playtimeDao.addUserPlaytime(playtimeDto.toEntity());
	}

}