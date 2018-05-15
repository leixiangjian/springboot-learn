package com.springboot.learn.web.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.springboot.learn.web.httpmessageconverters.CustomerStringHttpMessageConverter;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport{
	private static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);
	@Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new CustomerStringHttpMessageConverter());
        for (HttpMessageConverter<?> messageConverter : converters) {
        	logger.info("{}",messageConverter.getClass().getName()); //2
        }
    }
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//converters.add(new CustomerStringHttpMessageConverter());
	}

}
