package com.like.hrm.payitem.application.port.in.payexpression.save;

import com.like.hrm.payitem.domain.payexpression.PayExpression;

public class PayExpressionSaveDTOMapper {
	
	public static PayExpression newEntity(PayExpressionSaveDTO dto) {
		
		return new PayExpression(
				dto.companyCode(), 
				dto.payItemCode(),
				dto.payCondition(),
				dto.formula(),				
				dto.seq(),
				dto.comment()
				);
	}
	
	public static PayExpression modifyEntity(PayExpression entity, PayExpressionSaveDTO dto) {
		entity.modify(
				dto.payCondition(),
				dto.formula(),				
				dto.seq(),
				dto.comment()
				);
		
		return entity;
	}
}
