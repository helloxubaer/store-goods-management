package com.mycompany.storemanager.rest;

public class ProductRestInputErrorMessage {
	
	private int httpStatus;
	private String errorMessage;
	private long timeStamp;
	
	// define constructor s
	public ProductRestInputErrorMessage() {

	}
	public ProductRestInputErrorMessage(int httpStatus, String errorMessage, 
			long timeStamp) {
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}
	
	// add getter and setters
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
