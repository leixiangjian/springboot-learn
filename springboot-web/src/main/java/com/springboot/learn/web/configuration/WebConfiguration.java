package com.springboot.learn.web.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springboot.learn.web.converter.StringToDateConverter;
import com.springboot.learn.web.formatter.BookFormatter;
import com.springboot.learn.web.httpmessageconverters.CustomerStringHttpMessageConverter;
import com.springboot.learn.web.interceptor.CustomerHandlerInterceptor;
import com.springboot.learn.web.interceptor.CustomerWebRequestInterceptor;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
	private static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new CustomerStringHttpMessageConverter());
		for (HttpMessageConverter<?> messageConverter : converters) {
			logger.info("{}", messageConverter.getClass().getName()); // 2
		}
	}

	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// converters.add(new CustomerStringHttpMessageConverter());

	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	/**
     * 视图控制器配置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("/index");
    }

	/**
     * 配置请求视图映射
     * @return
     */
    @Bean
    public InternalResourceViewResolver resourceViewResolver()
    {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //请求视图文件的前缀地址
        internalResourceViewResolver.setPrefix("/webjars/html");
        //请求视图文件的后缀
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }
    
    /**
     * 视图配置
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(resourceViewResolver());
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
