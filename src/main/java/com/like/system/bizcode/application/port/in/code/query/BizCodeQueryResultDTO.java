package com.like.system.bizcode.application.port.in.code.query;

import lombok.Data;

@Data
public class BizCodeQueryResultDTO {

	String clientAppUrl;
	String companyCode;
	String typeId;
	String code;
	String codeName;
	Boolean useYn;
	Integer sequence;
	String comment;
		
}
