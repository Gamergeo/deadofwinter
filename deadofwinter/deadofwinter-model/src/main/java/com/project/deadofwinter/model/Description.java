package com.project.deadofwinter.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;
import com.project.deadofwinter.model.constant.DescriptionType;
import com.project.deadofwinter.technical.exception.ProjectException;

@Entity(name=BaseTableName.TABLE_NAME_DESCRIPTION)
@Table(name=BaseTableName.TABLE_NAME_DESCRIPTION)
public class Description implements ModelObject {
	
	private static final long serialVersionUID = 104200127351405437L;

	@Id
	@Column(name=BaseColumnName.COLUMN_DESCRIPTION_ID)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Column(name=BaseColumnName.COLUMN_DESCRIPTION_TEXT)
	protected String text;

	@Column(name=BaseColumnName.COLUMN_DESCRIPTION_NUMBERTOREPLACE)
	protected int numberToReplace;
	
	@Enumerated
	@Column(name=BaseColumnName.COLUMN_DESCRIPTION_TYPE)
	protected DescriptionType type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumberToReplace() {
		return numberToReplace;
	}

	public void setNumberToReplace(int numberToReplace) {
		this.numberToReplace = numberToReplace;
	}

	public DescriptionType getType() {
		return type;
	}

	public void setType(DescriptionType type) {
		this.type = type;
	}
	
	@Override
	public void validate(List<String> errors) throws ProjectException {
		
		if (errors == null) {
			throw new NullPointerException("object errors is null");
		}
		
		if (getType() == null) {
			throw new ProjectException("type is null");
		}
		
		if (getType().equals(DescriptionType.VICTORY) && StringUtils.isEmpty(getText())) {
			errors.add("Victory conditions must not be empty");
		}
	}
}
