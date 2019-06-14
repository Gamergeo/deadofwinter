package com.project.deadofwinter.business;

import org.springframework.stereotype.Service;

import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.technical.exception.ProjectException;

@Service
public interface SearchService {

	public MainObjective search(boolean isOriginal, boolean isExtension, boolean isCustom) throws ProjectException;

}
