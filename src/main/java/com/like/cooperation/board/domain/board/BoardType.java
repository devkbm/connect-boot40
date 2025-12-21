package com.like.cooperation.board.domain.board;

import jakarta.persistence.EnumeratedValue;

public enum BoardType {
	BOARD("BRD","일반게시판"),
	/**
	 * 관리자만 등록가능 
	 */
	NOTICE("NOT","공지사항")
	;
	
	@EnumeratedValue
	private String code;
	private String name;
	
	private BoardType(final String code, final String name) {
		this.code = code;
        this.name = name;
	}
	
    public String getCode() {
        return code;
    }
    	
    public String getName() {
        return name;
    }
	
}
