package com.like.cooperation.team.application.port.in.select;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

@Builder
public record TeamSelectDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,
		String companyCode,
		String teamId,
		String teamName,
		List<String> memberList
		) {
		
	
	
}