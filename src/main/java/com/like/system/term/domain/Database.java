package com.like.system.term.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.like.common.dto.HtmlSelectOptionable;

import jakarta.persistence.EnumeratedValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Database implements HtmlSelectOptionable {
	
	H2("H2",0L),
	ORACLE("오라클",1L), 
	MYSQL("MYSQL",2L)
	;
	
	@EnumeratedValue
	private String name;
	private Long seq;
	
	private Database(final String name, Long seq) {
		this.name= name;
		this.seq = seq;
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
		return this.seq;
	}
}
