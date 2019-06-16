package com.project.deadofwinter.business.mainobjective.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.deadofwinter.business.mainobjective.SearchMainObjectiveService;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.persistance.impl.MainObjectiveDao;
import com.project.deadofwinter.technical.exception.ProjectException;

@Service("searchMainObjectiveService")
public class SearchMainObjectiveServiceImpl implements SearchMainObjectiveService {
	
	@Autowired
	private MainObjectiveDao mainObjectiveDao;

	@Override
	@Transactional
	public MainObjective search(boolean isOriginal, boolean isExtension, boolean isCustom) throws ProjectException {
		
		List<MainObjective> mainObjectives = mainObjectiveDao.findAll(isOriginal, isExtension, isCustom);
		
		if (mainObjectives.isEmpty()) {
			throw new ProjectException("No main objective found");
		}
		
		if (mainObjectives.size() == 1) {
			return mainObjectives.get(0);
		}
		
		Random random = new Random();
		int randomNumber = random.nextInt(mainObjectives.size());
		
		return mainObjectives.get(randomNumber);
		
	}

	public void setMainObjectiveDao(MainObjectiveDao mainObjectiveDao) {
		this.mainObjectiveDao = mainObjectiveDao;
	}

	public MainObjectiveDao getMainObjectiveDao() {
		return mainObjectiveDao;
	}
}
