package com.project.deadofwinter.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;
import com.project.deadofwinter.model.constant.DescriptionType;

@Entity(name=BaseTableName.TABLE_NAME_DESCRIPTION)
@Table(name=BaseTableName.TABLE_NAME_DESCRIPTION)
public class Description {
	
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
	
	@Transient
	protected List<String> lines = null;

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
		this.lines = new LinkedList<String>(Arrays.asList(StringUtils.delimitedListToStringArray(text, "\\n")));
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
	
	/**
	 * @return a copy of a list of the text. Each element means one sentence, ordered
	 */
	public List<String> getLines() {
		
		if (lines == null) {
			lines = new LinkedList<String>(Arrays.asList(StringUtils.delimitedListToStringArray(text, "\\n")));
		}
		
		return new LinkedList<String>(lines);
	}
}
