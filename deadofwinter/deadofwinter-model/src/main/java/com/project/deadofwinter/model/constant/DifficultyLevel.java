package com.project.deadofwinter.model.constant;

public enum DifficultyLevel {
	NORMAL("Normal"),
	HARD("Difficile"),
	EXTREME("Extreme");
	
	private String text;
	
	private DifficultyLevel(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
