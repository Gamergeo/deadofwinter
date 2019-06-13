package com.project.deadofwinter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;

@Entity(name = BaseTableName.TABLE_NAME_DIFFICULTY)
@Table(name = BaseTableName.TABLE_NAME_DIFFICULTY)
public class Difficulty {

	@Id
	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_NUMBERS_VICTORY)
	protected String replacingNumbersVictory;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_NUMBERS_ADDITIONALRULE)
	protected String replacingNumbersAdditionalRule;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_LEVEL)
	protected int level;

	@ManyToOne
	@JoinColumn(name = BaseColumnName.COLUMN_DIFFICULTY_DIFFICULTY_RULE, referencedColumnName = BaseColumnName.COLUMN_DESCRIPTION_ID)
	protected Description difficultyRule;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_NUMBERS_DIFFICULTYRULE)
	protected String replacingNumbersDifficultyRule;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_MORAL)
	protected int moral;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_NUMBERTURN)
	protected int numberTurn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReplacingNumbersVictory() {
		return replacingNumbersVictory;
	}

	public void setReplacingNumbersVictory(String replacingNumbersVictory) {
		this.replacingNumbersVictory = replacingNumbersVictory;
	}

	public String getReplacingNumbersAdditionalRule() {
		return replacingNumbersAdditionalRule;
	}

	public void setReplacingNumbersAdditionalRule(String replacingNumbersAdditionalRule) {
		this.replacingNumbersAdditionalRule = replacingNumbersAdditionalRule;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Description getDifficultyRule() {
		return difficultyRule;
	}

	public void setDifficultyRule(Description difficultyRule) {
		this.difficultyRule = difficultyRule;
	}

	public String getReplacingNumbersDifficultyRule() {
		return replacingNumbersDifficultyRule;
	}

	public void setReplacingNumbersDifficultyRule(String replacingNumbersDifficultyRule) {
		this.replacingNumbersDifficultyRule = replacingNumbersDifficultyRule;
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
	
	public String getReplacingNumber(int index) {

		return StringUtils.delimitedListToStringArray(getAdditionalRule().getText(), "\\n");
	}
}
