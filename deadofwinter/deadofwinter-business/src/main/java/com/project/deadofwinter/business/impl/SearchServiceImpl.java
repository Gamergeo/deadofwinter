package com.project.deadofwinter.business.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.deadofwinter.business.SearchService;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.persistance.impl.MainObjectiveDao;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private MainObjectiveDao mainObjectiveDao;

	@Override
	@Transactional
	public MainObjective search(boolean isOriginal, boolean isExtension, boolean isCustom) {
		
		List<MainObjective> mainObjectives = mainObjectiveDao.findAll(isOriginal, isExtension, isCustom);
		
		if (mainObjectives.isEmpty()) {
			throw new RuntimeException("No main objective found");
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
