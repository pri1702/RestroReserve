package com.pri.resp;

public class AppResponse {
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	
	private String status = AppResponse.SUCCESS;
	private String message;
	
	private Object payLoad;//data
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}
}
