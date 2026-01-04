package com.like.system.hierarchycode.application.port.in.save;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record HierarchyCodeSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,			
		String companyCode,		
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