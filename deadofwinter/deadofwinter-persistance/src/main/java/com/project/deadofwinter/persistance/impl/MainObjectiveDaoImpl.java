package com.project.deadofwinter.persistance.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.model.constant.BaseTableName;
import com.project.deadofwinter.persistance.AbstractDAO;

@Repository("mainObjectiveDao")
public class MainObjectiveDaoImpl extends AbstractDAO<MainObjective> implements MainObjectiveDao {

	@Override
	protected void setTypeParameterClass() {
		typeParameterClass = MainObjective.class;
	}

	@Override
	public List<MainObjective> findAll() {
		return findAll(BaseTableName.TABLE_NAME_MAIN_OBJECTIVE);
	}

	@Override
	public List<MainObjective> findAll(boolean isOriginal, boolean isExtension, boolean isCustom) {

		if (isOriginal && isExtension && isCustom) {
			return findAll();
		}

		String query = "FROM " + BaseTableName.TABLE_NAME_MAIN_OBJECTIVE + " mo WHERE ";
		
		if (isOriginal) {
			query += "original = 1 ";
			
			if (isExtension || isCustom) {
				query += "OR ";
			}
		}
		
		if (isExtension) {
			query += "extension = 1 ";
			
			if (isCustom) {
				query += "OR ";
			}
		}
		
		if (isCustom) {
			query += "custom = 1 ";
		}

		TypedQuery<MainObjective> typedQuery = getCurrentSession().createQuery(query, MainObjective.class);

		return typedQuery.getResultList();
	}
}
