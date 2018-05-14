package com.springboot.learn.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.apachecommons.CommonsLog;

@SpringBootApplication
@CommonsLog
public class LogApplication {
	public static void main(String[] args) {
		log.info("xxx");
		SpringApplication.run(LogApplication.class, args);
	}

}
