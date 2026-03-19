package com.like.system.term.application.port.in.term;

import com.like.system.term.domain.TermDictionary;

public class TermSelectDTOMapper {

	public static TermSelectDTO toDTO(TermDictionary entity) {		
		return TermSelectDTO.builder()						   					   					   						  
					   .term(entity.getTerm())
					   .termEng(entity.getTermEng())
					   .definition(entity.getDefinition())
					   .status(entity.getStatus())
					   .system(entity.getSystem())
					   .columnName(entity.getColumnName())
					   .size(entity.getSize())
					   .comment(entity.getComment())
					   .dataDomainId(entity.getDataDomain().getId())
					   .dataDomainName(entity.getDataDomain().getDomainName())					   					   
					   .build();						   
	}
		
}

