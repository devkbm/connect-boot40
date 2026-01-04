package com.like.system.hierarchycode.application.port.in.select;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record HierarchyCodeSelectDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,			
		String companyCode,
		String systemTypeCode,
		String codeId,
		String parentId,			
		String code,
		String codeName,
		String codeNameAbbreviation,
		LocalDateTime fromDate,
		LocalDateTime toDate,
		Integer hierarchyLevel,
		Integer seq,			
		Integer lowLevelCodeLength,
		String cmt
		) {
		
	
}