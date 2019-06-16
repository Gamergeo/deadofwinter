package com.project.deadofwinter.business.mainobjective.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.deadofwinter.business.mainobjective.MainObjectiveService;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.persistance.impl.MainObjectiveDao;

@Service("mainObjectiveService")
public class MainObjectoveServiceImpl implements MainObjectiveService {
	
	@Autowired
	private MainObjectiveDao mainObjectiveDao;

	/**
	 * @see MainObjectiveService.save(MainObjective)
	 */
	@Override
	@Transactional
	public void save(MainObjective mainObjective) {
		mainObjectiveDao.persist(mainObjective);
	}

	public void setMainObjectiveDao(MainObjectiveDao mainObjectiveDao) {
		this.mainObjectiveDao = mainObjectiveDao;
	}

	public MainObjectiveDao getMainObjectiveDao() {
		return mainObjectiveDao;
	}
}
