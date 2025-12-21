package com.like.system.term.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.like.common.dto.HtmlSelectOptionable;

import jakarta.persistence.EnumeratedValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Database implements HtmlSelectOptionable {
	
	ORACLE("오라클"), 
	MYSQL("MYSQL")
	;
	
	@EnumeratedValue
	private String name;
	
	private Database(final String name) {
		this.name= name;
	}

	@Override
	public String getLabel() {
		return this.name;
	}

	@Override
	public String getValue() {
		return this.toString();
	}

	@Override
	public Long getSequence() {
		// TODO Auto-generated method stub
		return null;
	}
}
