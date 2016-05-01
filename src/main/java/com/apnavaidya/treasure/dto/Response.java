package com.apnavaidya.treasure.dto;

import java.io.Serializable;

public class Response implements Serializable {

	private int responseCode = 200;

	private String message = "SUCCESS";

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
