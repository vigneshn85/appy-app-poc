package com.appy.business.user.exception;


public class UserException extends Exception{

	private String operation;
	private String fieldFailure;

	public UserException(String operation, String fieldFailure) {
		super();
		this.operation = operation;
		this.fieldFailure = fieldFailure;
	}

	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getFieldFailure() {
		return fieldFailure;
	}

	public void setFieldFailure(String fieldFailure) {
		this.fieldFailure = fieldFailure;
	}	
}
