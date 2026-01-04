package com.like.system.hierarchycode.application.port.in.save;

import com.like.system.hierarchycode.domain.Code;

public class HierarchyCodeSaveDTOMapper {
	
	public static Code newEntity(HierarchyCodeSaveDTO dto, Code parentCode) {
		
		Code entity = Code.builder()
						  .companyCode(dto.companyCode())
						  .parentCode(parentCode)
						  .code(dto.code())
						  .codeName(dto.codeName())
						  .codeNameAbbreviation(dto.codeNameAbbreviation())				
						  .fromDate(dto.fromDate())
						  .toDate(dto.toDate())
						  .seq(dto.seq())							  
						  .lowLevelCodeLength(dto.lowLevelCodeLength())
						  .cmt(dto.cmt())
						  .build();
		
		entity.createdAppUrl(dto.clientAppUrl());
		
		return entity;
	}
	
	public static void modifyEntity(Code entity, HierarchyCodeSaveDTO dto) {
		entity.modifyEntity(
				dto.codeName(),
				dto.codeNameAbbreviation(),
				dto.fromDate(),
				dto.toDate(),
				dto.seq(),
				dto.lowLevelCodeLength(),
				dto.cmt()
				);
		
		entity.createdAppUrl(dto.clientAppUrl());
	}
	
}
