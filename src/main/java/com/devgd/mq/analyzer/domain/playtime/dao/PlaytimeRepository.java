package com.devgd.mq.analyzer.domain.playtime.dao;

import java.util.Optional;

import com.devgd.mq.analyzer.domain.playtime.domain.PlaytimeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaytimeRepository extends JpaRepository<PlaytimeEntity, String> {
	Optional<PlaytimeEntity> findByUserIdAndMusicId(Integer userId, String musicId);
}