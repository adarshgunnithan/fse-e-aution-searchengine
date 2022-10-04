package com.cts.eaution.exception;

public class SearchException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6668723675659736138L;
	/**
	 * exception message
	 */
	private String message;
	/**
	 * exception details
	 */
	private String descrpition;
	
	public SearchException(String message, String descrpition) {
		super();
		this.message = message;
		this.descrpition = descrpition;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescrpition() {
		return descrpition;
	}
	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}
}
