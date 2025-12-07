package com.like.hrm.payitem.application.port.in.payexpression.select;

import lombok.Builder;

@Builder
public record PayExpressionSelectDTO(
		String clientAppUrl,
		String id,
		String companyCode,
		String payItemCode,
		String payCondition,
		String formula,		
		Long seq,
		String comment
		) {
}
