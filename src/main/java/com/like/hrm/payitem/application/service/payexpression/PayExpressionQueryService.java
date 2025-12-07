package com.like.hrm.payitem.application.service.payexpression;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryDTO;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryResultDTO;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryUseCase;
import com.like.hrm.payitem.application.port.out.PayExpressionQueryDbPort;

@Service
public class PayExpressionQueryService implements PayExpressionQueryUseCase {

	PayExpressionQueryDbPort dbPort;
	
	PayExpressionQueryService(PayExpressionQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<PayExpressionQueryResultDTO> query(PayExpressionQueryDTO dto) {
		return this.dbPort.query(dto);
	}
	
}
