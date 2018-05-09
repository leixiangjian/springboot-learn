package com.springboot.learn.configuration.annotationimport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learn.configuration.annotationimport.service.ImportService;

@RestController
public class ImportController {

    @Autowired
    ImportService importService;

    @GetMapping("/book/hello")
    public String sayHello() {
        return "Hello， " + importService.test();
    }
	
}
