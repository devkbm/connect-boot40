package com.like.system.hierarchycode.application.port.in.query;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HierarchyCodeQueryResultDTO {

	String companyCode;
	String parentCodeId;
	String codeId;
	String code;
	String codeName;
	String codeNameAbbreviation;
	LocalDateTime fromDate;
	LocalDateTime toDate;
	Integer hierarchyLevel;
	Integer lowLevelCodeLength;
	Integer seq;
	String cmt;
}
