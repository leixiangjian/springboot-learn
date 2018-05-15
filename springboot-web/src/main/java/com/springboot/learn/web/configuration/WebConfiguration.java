package com.springboot.learn.web.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.springboot.learn.web.converter.StringToDateConverter;
import com.springboot.learn.web.formatter.BookFormatter;
import com.springboot.learn.web.httpmessageconverters.CustomerStringHttpMessageConverter;
import com.springboot.learn.web.interceptor.CustomerHandlerInterceptor;
import com.springboot.learn.web.interceptor.CustomerWebRequestInterceptor;

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
	
	@Override
	public FormattingConversionService mvcConversionService() {
		StringToDateConverter stringToDateConverter = new StringToDateConverter("yyyy-MM-dd HH:mm");
		FormattingConversionService formattingConversionService = super.mvcConversionService();
		formattingConversionService.addConverter(stringToDateConverter);
		return formattingConversionService;
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
	    registry.addFormatter(new BookFormatter());
	}
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CustomerHandlerInterceptor());
		registry.addWebRequestInterceptor(new CustomerWebRequestInterceptor());
	}

}
