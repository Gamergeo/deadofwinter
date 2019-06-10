package com.project.deadofwinter.model;

import org.springframework.stereotype.Component;

@Component
public class Search {
	
	private boolean hard;
	
	private boolean custom;

	private boolean original;

	private boolean extension;

	public boolean isHard() {
		return hard;
	}

	public void setHard(boolean isHard) {
		this.hard = isHard;
	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public boolean isExtension() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}
}
