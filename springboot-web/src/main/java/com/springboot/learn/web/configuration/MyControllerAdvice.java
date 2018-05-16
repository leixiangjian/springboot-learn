package com.springboot.learn.web.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.learn.web.exception.CustomerException;

@ControllerAdvice
public class MyControllerAdvice {

	/**
	 * 全局异常捕捉处理
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Map errorHandler(Exception ex) {
		Map map = new HashMap();
		map.put("code", 100);
		map.put("msg", ex.getMessage());
		return map;
	}

	/**
	 * 拦截捕捉自定义异常 CustomerException.class
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = CustomerException.class)
	public ModelAndView myErrorHandler(CustomerException ex) {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName(String.format("%s%s", "/errors/",ex.getCode()));
	    modelAndView.addObject("code", ex.getCode());
	    modelAndView.addObject("msg", ex.getMsg());
	    return modelAndView;
	}
}
