package com.vishwavijay.sample.springbootspringmvcspringsecurity.response;

import java.util.Date;

public class Status {
	private final String message;
	private final Date date;
	
	public Status(String message) {
		this.message = message;
		this.date = new Date();
	}

	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}
	
	public static Status of(String message) {
		return new Status(message);
	}
}
