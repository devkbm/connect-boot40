package com.like.system.hierarchycode.application.port.in.select;

import org.jspecify.annotations.Nullable;

import com.like.system.hierarchycode.domain.Code;

public class HierarchyCodeSelectDTOMapper {

	public static @Nullable HierarchyCodeSelectDTO map(Code entity) {					
		
		if (entity == null) return null;
		
		Code parent = entity.getParentCode();
									
		return HierarchyCodeSelectDTO.builder()
				   .createdDt(entity.getCreatedDt())
				   .createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
				   .modifiedDt(entity.getModifiedDt())
				   .modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())					   
				   .systemTypeCode(entity.id().companyCode())
				   .codeId(entity.id().codeId())
				   .parentId(parent == null ? null : parent.id().codeId())
				   .code(entity.code())
				   .codeName(entity.codeName())
				   .codeNameAbbreviation(entity.codeNameAbbreviation())								
				   .fromDate(entity.fromDate())
				   .toDate(entity.toDate())
				   .hierarchyLevel(entity.hierarchyLevel())
				   .seq(entity.seq())					   				   
				   .cmt(entity.cmt())
				   .build();	
	}
	
}
