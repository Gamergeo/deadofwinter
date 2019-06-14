package com.project.deadofwinter.webapp.form;

import org.springframework.stereotype.Component;

@Component
public class SearchrRandomMainObjectiveForm {
	
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
