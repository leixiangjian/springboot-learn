package com.springboot.learn.web.exception;

public class CustomerException extends RuntimeException {

	private static final long serialVersionUID = 2064580232295752160L;
	private String code;
	private String msg;

	public CustomerException(String code, String message) {
		this.code = code;
		this.msg = message;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public CustomerException() {
		super();
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}

	protected CustomerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
