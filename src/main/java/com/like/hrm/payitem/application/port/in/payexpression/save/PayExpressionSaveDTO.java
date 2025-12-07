package com.like.hrm.payitem.application.port.in.payexpression.save;

import lombok.Builder;

@Builder
public record PayExpressionSaveDTO(
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
