package com.project.deadofwinter.business.mainobjective;

import org.springframework.stereotype.Service;

import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.technical.exception.ProjectException;

@Service
public interface SearchMainObjectiveService {

	public MainObjective search(boolean isOriginal, boolean isExtension, boolean isCustom) throws ProjectException;
}
