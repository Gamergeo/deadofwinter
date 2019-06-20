package com.project.deadofwinter.model;

import java.io.Serializable;
import java.util.List;

import com.project.deadofwinter.technical.exception.ProjectException;

public interface ModelObject extends Serializable {
	
	public void validate(List<String> errors) throws ProjectException;
}
