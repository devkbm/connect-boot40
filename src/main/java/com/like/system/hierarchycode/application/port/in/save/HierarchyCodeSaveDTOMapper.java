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
						  .additionalInfo(dto.additionalInfo())
						  .cmt(dto.cmt())
						  .fromDate(dto.fromDate())
						  .toDate(dto.toDate())
						  .seq(dto.seq())							  						  						  
						  .build();
		
		entity.createdAppUrl(dto.clientAppUrl());
		
		return entity;
	}
	
	public static void modifyEntity(Code entity, HierarchyCodeSaveDTO dto) {
		
		entity.modifyBuilder()
			  .codeName(dto.codeName())
			  .codeNameAbbreviation(dto.codeNameAbbreviation())
			  .additionalInfo(dto.additionalInfo())
			  .fromDate(dto.fromDate())
			  .toDate(dto.toDate())
			  .seq(dto.seq())
			  .cmt(dto.cmt())
			  .modify();			
		
		entity.modifiedAppUrl(dto.clientAppUrl());
	}
	
}
