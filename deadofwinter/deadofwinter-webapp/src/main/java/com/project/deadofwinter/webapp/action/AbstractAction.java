package com.project.deadofwinter.webapp.action;

import java.io.Serializable;

public abstract class AbstractAction implements Serializable {
	
	private String errorMessage;	
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
//	protected HttpServletRequest getRequest() {
//		return ServletActionContext.getRequest();
//	}

}
