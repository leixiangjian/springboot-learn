package com.springboot.learn.log.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogController {
	public void log() {
	    log.info("call method LogController.log");
	}
}
