package com.gnsym.entity;

public class ResponseBody<Response> {
    int statusCode; 
	String message;
	Response response;
	
	public ResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseBody(int statusCode, String message, Response response) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.response = response;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
	
	

}
