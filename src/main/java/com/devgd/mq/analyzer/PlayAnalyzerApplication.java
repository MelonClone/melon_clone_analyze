package com.devgd.mq.analyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PlayAnalyzerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlayAnalyzerApplication.class, args);
	}

}
