package com.pri.exception;

public class AppException extends Exception {
	
	private static final long serialVersionUID = 7768774952031458428L;

	public AppException(String message){
		super(message);
	}
	
	public AppException ( String message, Throwable cause){
		super(message, cause);
	}

}
