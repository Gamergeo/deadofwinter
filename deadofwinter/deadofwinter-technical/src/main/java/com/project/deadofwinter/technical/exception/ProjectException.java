package com.project.deadofwinter.technical.exception;

public class ProjectException extends Exception {
	
	private static final long serialVersionUID = 1184984190667885763L;
	
	private String errorMessage;
	
	/**
	 * Manage the exception in the application game
	 */
	public ProjectException(Exception exception, String message) {
		exception.printStackTrace();
		
		errorMessage = message;
	}
	
	public ProjectException(String message) {
		errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
