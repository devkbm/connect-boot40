package com.like.system.bizcode.application.port.in.type.query;

import lombok.Builder;
import lombok.Data;

/*
@Builder
public record BizCodeTypeQueryResultDTO(
		String clientAppUrl,
		String companyCode,
		String typeId,			
		String typeName,			
		Integer sequence,
		String bizType,
		String comment
		) {

}
*/

@Data
public class BizCodeTypeQueryResultDTO {
	String clientAppUrl;
	String companyCode;
	String typeId;			
	String typeName;			
	Integer sequence;
	String bizType;
	String comment;		
}
