package com.like.hrm.payitem.adapter.out.db.payexpression;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.adapter.out.db.payexpression.querydsl.PayExpressionQuerydsl;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryDTO;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryResultDTO;
import com.like.hrm.payitem.application.port.out.PayExpressionQueryDbPort;

@Repository
public class PayExpressionQueryDbAdapter implements PayExpressionQueryDbPort {

	PayExpressionQuerydsl repository;
	
	PayExpressionQueryDbAdapter(PayExpressionQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<PayExpressionQueryResultDTO> query(PayExpressionQueryDTO dto) {
		return this.repository.query(dto);
	}

}
