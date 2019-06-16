package com.project.deadofwinter.business.mainobjective;

import org.springframework.stereotype.Service;

import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.technical.exception.ProjectException;

@Service
public interface MainObjectiveService {
	
	/**
	 * Insert or update main objective
	 */
	public void save(MainObjective mainObjective);

}
