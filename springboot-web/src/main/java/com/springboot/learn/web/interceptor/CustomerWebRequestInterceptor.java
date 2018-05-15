package com.springboot.learn.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

public class CustomerWebRequestInterceptor implements WebRequestInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(CustomerWebRequestInterceptor.class);
	@Override
	public void preHandle(WebRequest request) throws Exception {
		logger.info("call CustomerWebRequestInterceptor。preHandle");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		logger.info("call CustomerWebRequestInterceptor。postHandle");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		logger.info("call CustomerWebRequestInterceptor。afterCompletion");
	}

}
