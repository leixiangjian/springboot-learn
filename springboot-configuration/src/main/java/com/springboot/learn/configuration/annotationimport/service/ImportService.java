package com.springboot.learn.configuration.annotationimport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springboot.learn.configuration.annotationimport.DirectImport;

@Component
public class ImportService {
	@Autowired
	DirectImport directImport;
	
	@Value("${my.name}")
	String test;
	
	public String test() {
		return String.format("%s:%s:%s", "import-service",directImport.test(),test);
	}
}
