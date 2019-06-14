package com.project.deadofwinter.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;
import com.project.deadofwinter.model.constant.DescriptionType;
import com.project.deadofwinter.model.constant.DifficultyLevel;
import com.project.deadofwinter.technical.exception.ProjectException;

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

	@Enumerated
	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_LEVEL)
	protected DifficultyLevel level;

	@ManyToOne
	@JoinColumn(name = BaseColumnName.COLUMN_DIFFICULTY_DIFFICULTY_RULE, referencedColumnName = BaseColumnName.COLUMN_DESCRIPTION_ID)
	protected Description difficultyRule;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_NUMBERS_DIFFICULTYRULE)
	protected String replacingNumbersDifficultyRule;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_MORAL)
	protected int moral;

	@Column(name = BaseColumnName.COLUMN_DIFFICULTY_NUMBERTURN)
	protected int numberTurn;
	
	@Transient
	protected Map<DescriptionType, String[]> replacingNumbers = null;

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

	public DifficultyLevel getLevel() {
		return level;
	}

	public void setLevel(DifficultyLevel level) {
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
	
	/**
	 * @param type (type of description)
	 * @param index (index : 1 for first number...)
	 * @return the replacing number
	 * @throw Exception if number doesnt exist
	 */
	public String getReplacingNumber(DescriptionType type, int index) throws ProjectException {
		
		/* Initialisation mandatory if not done yet */
		if (replacingNumbers == null) {
			initReplacingNumbers();
		}
		
		/* Problem : number doesn't exist ! */
		if (replacingNumbers.get(type).length < index) {
			throw new ProjectException("number doesnt exist");
		}
		
		return replacingNumbers.get(type)[index-1];
	}

	/**
	 * Init the map of replacing numbers
	 */
	private void initReplacingNumbers () {
		replacingNumbers = new HashMap<DescriptionType, String[]>();
		
		replacingNumbers.put(DescriptionType.ADDITIONAL_RULE, StringUtils.delimitedListToStringArray(getReplacingNumbersAdditionalRule(), ","));
		replacingNumbers.put(DescriptionType.VICTORY, StringUtils.delimitedListToStringArray(getReplacingNumbersVictory(), ","));
		replacingNumbers.put(DescriptionType.DIFFICULTY_RULE, StringUtils.delimitedListToStringArray(getReplacingNumbersDifficultyRule(), ","));
	}
}
