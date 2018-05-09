package com.springboot.learn.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:applicationContext.xml"})
@ComponentScan(basePackages= {"com.springboot.learn.configuration.annotationimport.service","com.springboot.learn.configuration.annotationimport","com.springboot.learn.configuration.annotationimport.controller"})
@SpringBootApplication
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
