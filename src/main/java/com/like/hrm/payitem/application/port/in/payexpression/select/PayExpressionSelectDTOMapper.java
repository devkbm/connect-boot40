package com.like.hrm.payitem.application.port.in.payexpression.select;

import com.like.hrm.payitem.domain.payexpression.PayExpression;

public class PayExpressionSelectDTOMapper {

	public static PayExpressionSelectDTO toDTO(PayExpression entity) {
		if (entity == null) return null;
				
		return PayExpressionSelectDTO
				.builder()			
				.id(entity.getId().toString())
				.companyCode(entity.getCompanyCode())
				.payItemCode(entity.getPayItemCode())
				.payCondition(entity.getPayCondition())
				.formula(entity.getFormula())
				.seq(entity.getSeq())				
				.comment(entity.getComment())
				.build();
	}	
	
}
