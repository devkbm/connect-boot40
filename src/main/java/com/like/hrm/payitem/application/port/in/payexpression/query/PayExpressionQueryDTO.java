package com.like.hrm.payitem.application.port.in.payexpression.query;

import lombok.Builder;

@Builder
public record PayExpressionQueryDTO(
		String id,
		String companyCode,
		String payItemCode		
		) {
}
