package com.like.system.term.application.port.in.term;

import com.like.system.term.domain.DataDomainDictionary;
import com.like.system.term.domain.TermDictionary;

public class TermSaveDTOMapper {

	public static TermDictionary newEntity(TermSaveDTO dto, DataDomainDictionary dataDomain) {												
		return TermDictionary
				.builder()
				.term(dto.term())
				.termEng(dto.termEng())
				.definition(dto.definition())
				.status(dto.status())
				.system(dto.system())
				.columnName(dto.columnName())
				.size(dto.size())
				.dataDomain(dataDomain)
				.columnName(dto.comment())
				.build();
	}	
		
	public static void modifyEntity(
			TermSaveDTO dto, 
			TermDictionary entity, 
			DataDomainDictionary dataDomain
			) {
					
		entity.modifyEntity(
				dto.termEng(),
				dto.definition(),
				dto.status(),
				dto.system(),
				dto.columnName(),
				dto.size(),
				dataDomain,				
				dto.comment()
				);				
	}
}

