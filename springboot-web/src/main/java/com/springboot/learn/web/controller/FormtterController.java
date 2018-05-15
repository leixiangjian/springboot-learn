package com.springboot.learn.web.controller;

import java.awt.print.Book;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webformatter")
public class FormtterController {
	@RequestMapping(value = "/{isbn}/reviewers", method = RequestMethod.GET)
	public Book getReviewers(@PathVariable("isbn") Book book) {
	    return book;
	}
}
