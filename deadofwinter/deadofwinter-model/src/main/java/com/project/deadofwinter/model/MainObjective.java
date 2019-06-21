package com.project.deadofwinter.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;
import com.project.deadofwinter.model.constant.DescriptionType;
import com.project.deadofwinter.model.constant.DifficultyLevel;
import com.project.deadofwinter.model.constant.MainObjectiveType;
import com.project.deadofwinter.model.constant.TimeName;
import com.project.deadofwinter.technical.exception.ProjectException;
import com.project.deadofwinter.technical.util.ReplacingNumberUtil;

@Entity(name=BaseTableName.TABLE_NAME_MAIN_OBJECTIVE)
@Table(name=BaseTableName.TABLE_NAME_MAIN_OBJECTIVE)
public class MainObjective implements ModelObject {

	private static final long serialVersionUID = -5709894870019664446L;
	
	@Id
	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_ID)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_NAME)
	protected String name;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_VICTORY, referencedColumnName=BaseColumnName.COLUMN_DESCRIPTION_ID)
	protected Description victory;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_ADDRULE, referencedColumnName=BaseColumnName.COLUMN_DESCRIPTION_ID)
	protected Description additionalRule;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_DIFFICULTY_NORMAL, referencedColumnName=BaseColumnName.COLUMN_DIFFICULTY_ID)
	protected Difficulty difficultyNormal;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name=BaseColumnName.COLUMN_MAINOBJECTIVE_DIFFICULTY_HARD, referencedColumnName=BaseColumnName.COLUMN_DIFFICULTY_ID)
	protected Difficulty difficultyHard;
	
	@Enumerated
	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_TYPE)
	protected MainObjectiveType type;
	
	@Enumerated
	@Column(name=BaseColumnName.COLUMN_MAINOBJECTIVE_TIME)
	protected TimeName time;
	
	public MainObjective() {
		victory = new Description();
		victory.setType(DescriptionType.VICTORY);
		
		additionalRule = new Description();
		additionalRule.setType(DescriptionType.ADDITIONAL_RULE);
		
		difficultyNormal = new Difficulty();
		difficultyNormal.setLevel(DifficultyLevel.NORMAL);
		
		difficultyHard = new Difficulty();
		difficultyHard.setLevel(DifficultyLevel.HARD);
		
		type = MainObjectiveType.CUSTOM;
	}

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

	public MainObjectiveType getType() {
		return type;
	}

	public void setType(MainObjectiveType type) {
		this.type = type;
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
	
	public TimeName getTime() {
		return time;
	}
	
	public void setTime(TimeName time) {
		this.time = time;
	}
	
	/**
	 * Used for display.
	 * @return an array of additional rule(s), each element means one sentence. 
	 * @throws ProjectException 
	 */
	public String getNormalAdditionalRules() throws ProjectException {
		return replaceTextWithDifficultyNumbers(getAdditionalRule(), getDifficultyNormal());
	}
	
	
	/**
	 * @return a list of additional rule(s), each element means one sentence
	 * @throws ProjectException 
	 */
	public String getNormalVictoryText() throws ProjectException {		
		return replaceTextWithDifficultyNumbers(getVictory(), getDifficultyNormal());
	}
	
	/**
	 * @param description concerned description (numberToReplace)
	 * @param difficulty concerned difficulty (replacingNumbers)
	 * @return an array, each element means one line with numbers replaced
	 */
	private String replaceTextWithDifficultyNumbers(Description description, Difficulty difficulty) throws ProjectException {
		return ReplacingNumberUtil.replaceTextWithDifficultyNumbers(description.getText(), difficulty.getReplacingNumber(description.getType()));
	}
	
	/**
	 * validate the main objective
	 * @throws ProjectException 
	 */
	@Override
	public void validate(List<String> errors) throws ProjectException {
		
		if (errors == null) {
			throw new NullPointerException("object errors is null");
		}
		
		if (StringUtils.isEmpty(getName())) {
			errors.add("Name must not be empty");
		}

		if (getAdditionalRule() == null) {
			throw new ProjectException("object additional rule is null");
		}
		
		getAdditionalRule().validate(errors);
		validateReplacedNumbers(errors, getAdditionalRule());
		
		if (getVictory() == null) {
			throw new ProjectException("object victory is null");
		}
		
		getVictory().validate(errors);
		validateReplacedNumbers(errors, getVictory());
		
		if (getDifficultyNormal() == null) {
			throw new ProjectException("object normal difficulty is null");
		}
		
		getDifficultyNormal().validate(errors);
		
		if (getDifficultyHard() == null) {
			throw new ProjectException("object hard difficulty is null");
		}
		
		getDifficultyHard().validate(errors);
		
		if (getTime() == null) {
			throw new ProjectException("object time is null");
		}
		
		if (getType() == null) {
			throw new ProjectException("object type is null");
		}
	}
	
	private void validateReplacedNumbers(List<String> errors, Description description) throws ProjectException {
		validateReplacedNumbers(errors, description, getDifficultyNormal());
		validateReplacedNumbers(errors, description, getDifficultyHard());
	}
	
	/**
	 * Validate if the number of replacing number is matching the number of replaced number
	 * @throws ProjectException 
	 */
	private void validateReplacedNumbers(List<String> errors, Description description, Difficulty difficulty) throws ProjectException {
		
		// The number of replacing number should match the number of replacing numbers
		int victoryReplacedNumberLength = ReplacingNumberUtil.getReplacedNumberNumber(description.getText());
		
		if (victoryReplacedNumberLength != ReplacingNumberUtil.getReplcingdNumberNumber(difficulty.getReplacingNumber(description.getType()))) {
			errors.add("Incorrect number of replacing numbers for " + description.getType() + " and difficulty : " + difficulty.getLevel());
		}
	}
}
