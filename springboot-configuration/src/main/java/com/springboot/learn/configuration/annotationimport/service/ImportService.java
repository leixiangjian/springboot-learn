package com.springboot.learn.configuration.annotationimport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.learn.configuration.annotationimport.DirectImport;

//@Component
public class ImportService {
	@Autowired
	DirectImport directImport;
	
	public String test() {
		return String.format("%s:%s", "import-service",directImport.test());
	}
}
