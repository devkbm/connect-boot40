package com.like.hrm.payitem.application.port.out;

import java.util.Optional;

import com.like.hrm.payitem.domain.payexpression.PayExpression;

public interface PayExpressionCommandDbPort {

	Optional<PayExpression> select(Long id);
	
	void save(PayExpression entity);
	
	void delete(Long id);	
	
}
