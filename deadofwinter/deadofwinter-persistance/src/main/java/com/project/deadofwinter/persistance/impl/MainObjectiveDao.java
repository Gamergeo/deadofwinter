package com.project.deadofwinter.persistance.impl;

import java.util.List;

import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.persistance.IDao;

public interface MainObjectiveDao extends IDao<MainObjective> {

	/**
	 * @return the main objectives corresponding to selected options
	 */
	List<MainObjective> findAll(boolean isOriginal, boolean isExtension, boolean isCustom);


}