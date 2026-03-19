package com.like.system.term.application.port.in.term;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record TermSelectDTO(
		String companyCode,
		String clientAppUrl,			
		@NotEmpty(message = "용어는 필수 입력 값입니다.")
		String term,
		String termEng,
		String definition,
		String status,
		List<String> system,
		String columnName,
		String size,
		String comment,
		String dataDomainId,
		String dataDomainName			
		) {
	
}