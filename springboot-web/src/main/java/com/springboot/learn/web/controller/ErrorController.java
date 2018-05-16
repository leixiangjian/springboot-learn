package com.springboot.learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.learn.web.exception.CustomerException;

@Controller
@RequestMapping("/error")
public class ErrorController {
	@RequestMapping("/errorView")
	public ModelAndView returnModelAndView() throws CustomerException {
		CustomerException customerException = new CustomerException("500","服务器异常");
		throw customerException;
	}
}
