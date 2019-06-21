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

		// sSi on demande aucun ou tous les types, on les renvoit tous
		if ((isOriginal && isExtension && isCustom) || (!isOriginal && !isExtension && !isCustom)) {
			return findAll();
		}

		String query = "FROM " + BaseTableName.TABLE_NAME_MAIN_OBJECTIVE + " mo WHERE type = ";
		
		if (isOriginal) {
			query += "0";
			
			if (isExtension || isCustom) {
				query += " OR type = ";
			}
		}
		
		if (isExtension) {
			query += "1";
			
			if (isCustom) {
				query += " OR type = ";
			}
		}
		
		if (isCustom) {
			query += "2";
		}

		TypedQuery<MainObjective> typedQuery = getCurrentSession().createQuery(query, MainObjective.class);

		return typedQuery.getResultList();
	}
}
