package com.setyo.helloworld.model;

public class HelloWorldBean {
	private String message;

	
	public HelloWorldBean() {
		this.setMessage("Hello World Bean");
	}

	public HelloWorldBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
