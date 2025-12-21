package com.like.system.term.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.like.common.dto.HtmlSelectOptionable;

import jakarta.persistence.EnumeratedValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SystemType implements HtmlSelectOptionable {
	HRM("인사관리"),
	GROUPWARE("그룹웨어"),
	SYSTEM("시스템")
	;

	@EnumeratedValue
	private String name;
	
	private SystemType(final String name) {
		this.name = name;
	}
	
	@Override
	public String getLabel() {
		return name;
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
