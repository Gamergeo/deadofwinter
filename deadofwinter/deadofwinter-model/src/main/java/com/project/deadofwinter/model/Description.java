package com.project.deadofwinter.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.deadofwinter.model.constant.BaseColumnName;
import com.project.deadofwinter.model.constant.BaseTableName;

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
}
