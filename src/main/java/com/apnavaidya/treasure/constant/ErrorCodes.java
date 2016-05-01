package com.apnavaidya.treasure.constant;

public class ErrorCodes {

	private int code;;
	private String message;

	ErrorCodes(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ErrorCodes [code=" + code + ", message=" + message + "]";
	}

}
