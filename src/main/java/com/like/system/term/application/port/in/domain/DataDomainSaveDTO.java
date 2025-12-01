package com.like.system.term.application.port.in.domain;

import lombok.Builder;

@Builder
public record DataDomainSaveDTO(
		String companyCode,
		String clientAppUrl,
		String domainId,
		String database,
		String domainName,
		String dataType,
		String comment
		) {
	
}