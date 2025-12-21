package com.like.cooperation.board.application.port.in.board.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.like.common.dto.HtmlSelectOptionable;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BoardTypeDTO implements HtmlSelectOptionable {
	/**
	 * 관리자만 등록가능 
	 */
	NOTICE("NOTICE","공지사항", 1L),
	
	BOARD("BOARD","일반게시판", 0L);
	
	private String code;
	private String name;
	private Long seq;
	
	private BoardTypeDTO(final String code, final String name, final Long seq) {
		this.code = code;
        this.name = name;
        this.seq = seq;
	}
	    
	@Override
	public String getLabel() {
		return name;		
	}

	@Override
	public String getValue() {
		return code;
	}

	@Override
	public Long getSequence() {		
		return seq;
	}
	
}
