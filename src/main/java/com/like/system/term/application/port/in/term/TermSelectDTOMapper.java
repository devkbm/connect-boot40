package com.like.system.term.application.port.in.term;

import com.like.system.term.domain.TermDictionary;

public class TermSelectDTOMapper {

	public static TermSelectDTO toDTO(TermDictionary entity) {		
		return TermSelectDTO.builder()						   					   					   						  
					   .term(entity.term())
					   .termEng(entity.termEng())
					   .definition(entity.definition())
					   .status(entity.status())
					   .system(entity.system())
					   .columnName(entity.columnName())
					   .size(entity.size())
					   .comment(entity.comment())
					   .dataDomainId(entity.dataDomain().id())
					   .dataDomainName(entity.dataDomain().domainName())					   					   
					   .build();						   
	}
		
}

