package com.like.system.term.application.port.in.word;

import lombok.Builder;

@Builder
public record WordSaveDTO(
		String companyCode,
		String clientAppUrl,
		String logicalName,
		String logicalNameEng,
		String physicalName,
		String comment
		) {	
}