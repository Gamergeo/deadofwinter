package com.project.deadofwinter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;
import com.project.deadofwinter.model.constant.DescriptionType;
import com.project.deadofwinter.model.constant.DifficultyLevel;
import com.project.deadofwinter.technical.exception.ProjectException;
import com.project.deadofwinter.technical.util.ReplacingNumberUtil;

@Entity(name = BaseTableName.TABLE_NAME_DIFFICULTY)
@Table(name = BaseTableName.TABLE_NAME_DIFFICULTY)
public class Difficulty implements ModelObject {

	private static final long serialVersionUID = 4958678694202760537L;

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
	 * @return replacing numbers
	 * @throw Exception if number doesnt exist
	 */
	public String getReplacingNumber(DescriptionType type) throws ProjectException {

		if (type.equals(DescriptionType.VICTORY)) {
			return getReplacingNumbersVictory();
			
		} else if (type.equals(DescriptionType.ADDITIONAL_RULE)) {
			return getReplacingNumbersAdditionalRule();
			
		} else if (type.equals(DescriptionType.DIFFICULTY_RULE)) {
			return getReplacingNumbersDifficultyRule();
		}
		
		throw new ProjectException(type.name() + " is not managed !");
	}

	@Override
	public void validate(List<String> errors) throws ProjectException {
		
		if (errors == null) {
			throw new NullPointerException("object errors is null");
		}
		
		if (getLevel() == null) {
			throw new ProjectException("difficulty level is null");
		}
		
		if (getMoral() == 0) {
			errors.add("Moral must not be 0. Difficulty :" + getLevel().getText());
		}
		
		if (getNumberTurn() == 0) {
			errors.add("Number of turns must not be 0. Difficulty :" + getLevel().getText());
		}
		
		// Validate if all replacing number are correctly set
		validateReplacingNumber(errors, DescriptionType.ADDITIONAL_RULE);
		validateReplacingNumber(errors, DescriptionType.VICTORY);
	}
	
	
	private void validateReplacingNumber(List<String> errors, DescriptionType type) throws ProjectException {
		
		for (String replacingNumber : ReplacingNumberUtil.getReplacingNumberAsList(getReplacingNumber(type))) {
			
			try {
				Integer.valueOf(replacingNumber);
			} catch (NumberFormatException e) {
				errors.add("Replacing number " + replacingNumber + " in " + type + "is not a number");
			}
		}
	}
}
