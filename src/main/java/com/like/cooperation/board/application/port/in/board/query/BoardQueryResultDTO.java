package com.like.cooperation.board.application.port.in.board.query;

import lombok.Data;

@Data
public class BoardQueryResultDTO {
	String clientAppUrl;
	String companyCode;
	String boardId;
	String boardParentId;
	String boardType;
	String boardName;
	String boardDescription;			
	Boolean useYn;			
	long sequence;	
}