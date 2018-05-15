package com.springboot.learn.web.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webconverter")
public class ConverterController {
	private static final Logger logger = LoggerFactory.getLogger(ConverterController.class);
	@RequestMapping(value="/converter", method={RequestMethod.POST,RequestMethod.GET})
	public String converter(Date time) {
		logger.info("converter:{}",time.getTime());
		return time.toString();
	}
}
