package com.project.deadofwinter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;

@Entity(name=BaseTableName.TABLE_NAME_MAIN_OBJECTIVE)
@Table(name=BaseTableName.TABLE_NAME_MAIN_OBJECTIVE)
public class MainObjective implements Serializable {

	private static final long serialVersionUID = -5709894870019664446L;
	
	@Id
	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_ID)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_MORAL)
	protected int moral;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_NUMBERTURN)
	protected int numberTurn;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_NAME)
	protected String name;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_OBJECTIVE)
	protected String objecive;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_ADDRULE)
	protected String additionalRule;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_ORIGINAL)
	protected boolean original;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_EXTENSION)
	protected boolean extension;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_CUSTOM)
	protected boolean custom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoral() {
		return moral;
	}

	public void setMoral(int moral) {
		this.moral = moral;
	}

	public int getNumberTurn() {
		return numberTurn;
	}

	public void setNumberTurn(int numberTurn) {
		this.numberTurn = numberTurn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjecive() {
		return objecive;
	}

	public void setObjecive(String objecive) {
		this.objecive = objecive;
	}

	public String getAdditionalRule() {
		return additionalRule;
	}

	public void setAdditionalRule(String additionalRule) {
		this.additionalRule = additionalRule;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public boolean isExtension() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}

	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
