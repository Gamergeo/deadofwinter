package com.project.deadofwinter.model.constant;

public enum TimeName {
	SHORT("COURTE"),
	MEDIUM("MOYENNE"),
	LONG("LONGUE");
	
	private String text;
	
	private TimeName(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return getText();
	}
}