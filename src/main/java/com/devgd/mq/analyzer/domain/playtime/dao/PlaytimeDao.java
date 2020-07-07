package com.devgd.mq.analyzer.domain.playtime.dao;

import com.devgd.mq.analyzer.domain.playtime.domain.PlaytimeEntity;
import com.devgd.mq.analyzer.domain.playtime.exception.PlaytimeNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaytimeDao {
	// TODO
	private final PlaytimeRepository playtimeRepository;

	public PlaytimeEntity addUserPlaytime(PlaytimeEntity playtimeEntity) {
		return playtimeRepository.save(playtimeEntity);
	}

	public PlaytimeEntity getPlaytime(Integer userId, String musicId) {
		return playtimeRepository.findByUserIdAndMusicId(userId, musicId)
			.orElseThrow(() -> new PlaytimeNotFoundException("Music Id " + musicId+" And User Id " + userId));
	}
}