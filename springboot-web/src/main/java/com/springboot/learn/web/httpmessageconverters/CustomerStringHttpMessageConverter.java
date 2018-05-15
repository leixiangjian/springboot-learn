package com.springboot.learn.web.httpmessageconverters;

import java.io.IOException;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.lang.Nullable;

public class CustomerStringHttpMessageConverter extends StringHttpMessageConverter {
	@Override
	public boolean supports(Class<?> clazz) {
		return String.class == clazz;
	}

	@Override
	protected String readInternal(Class<? extends String> clazz, HttpInputMessage inputMessage) throws IOException {
		return super.readInternal(clazz,inputMessage);
	}

	@Override
	protected Long getContentLength(String str, @Nullable MediaType contentType) {
		return super.getContentLength(str, contentType) ;
	}

	@Override
	protected void writeInternal(String str, HttpOutputMessage outputMessage) throws IOException {
		super.writeInternal(str,  outputMessage);
	}
}
