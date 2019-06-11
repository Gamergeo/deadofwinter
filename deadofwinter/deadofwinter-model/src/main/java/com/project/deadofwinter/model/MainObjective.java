package com.project.deadofwinter.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_NAME)
	protected String name;

	@ManyToOne
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_VICTORY, referencedColumnName=BaseColumnName.COLUMN_DESCRIPTION_ID)
	protected Description victory;

	@ManyToOne
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_ADDRULE, referencedColumnName=BaseColumnName.COLUMN_DESCRIPTION_ID)
	protected Description additionalRule;
	
	@ManyToOne
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_DIFFICULTY_NORMAL, referencedColumnName=BaseColumnName.COLUMN_DIFFICULTY_ID)
	protected Difficulty difficultyNormal;
	
	@ManyToOne
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_DIFFICULTY_HARD, referencedColumnName=BaseColumnName.COLUMN_DIFFICULTY_ID)
	protected Difficulty difficultyHard;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Description getVictory() {
		return victory;
	}

	public void setVictory(Description victory) {
		this.victory = victory;
	}

	public Description getAdditionalRule() {
		return additionalRule;
	}

	public void setAdditionalRule(Description additionalRule) {
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

	public Difficulty getDifficultyNormal() {
		return difficultyNormal;
	}

	public void setDifficultyNormal(Difficulty difficultyNormal) {
		this.difficultyNormal = difficultyNormal;
	}

	public Difficulty getDifficultyHard() {
		return difficultyHard;
	}

	public void setDifficultyHard(Difficulty difficultyHard) {
		this.difficultyHard = difficultyHard;
	}
}
