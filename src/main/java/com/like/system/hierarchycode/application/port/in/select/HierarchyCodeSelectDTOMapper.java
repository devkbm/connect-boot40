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
				   .systemTypeCode(entity.getId().getCompanyCode())
				   .codeId(entity.getId().getCodeId())
				   .parentId(parent == null ? null : parent.getId().getCodeId())
				   .code(entity.getCode())
				   .codeName(entity.getCodeName())
				   .codeNameAbbreviation(entity.getCodeNameAbbreviation())								
				   .fromDate(entity.getFromDate())
				   .toDate(entity.getToDate())
				   .hierarchyLevel(entity.getHierarchyLevel())
				   .seq(entity.getSeq())					   
				   .lowLevelCodeLength(entity.getLowLevelCodeLength())
				   .cmt(entity.getCmt())
				   .build();	
	}
	
}
