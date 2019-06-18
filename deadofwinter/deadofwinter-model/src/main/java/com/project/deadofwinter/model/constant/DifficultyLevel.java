package com.project.deadofwinter.model.constant;

import com.project.deadofwinter.technical.exception.ProjectException;

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
	
	@Override
	public String toString() {
		return getText();
	}
	
	public static DifficultyLevel retrieve(String text) throws ProjectException {
		
		if (NORMAL.getText().equals(text)) {
			return NORMAL;
		} else if (HARD.getText().equals(text)) {
			return HARD;
		} else if (EXTREME.getText().equals(text)) {
			return EXTREME;
		}
		
		throw new ProjectException("Difficulty doesn't exist : " + text);
	}
}
