package com.like.hrm.payitem.application.service.payexpression;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payexpression.delete.PayExpressionDeleteUseCase;
import com.like.hrm.payitem.application.port.out.PayExpressionCommandDbPort;

@Service
public class PayExpressionDeleteService implements PayExpressionDeleteUseCase {

	PayExpressionCommandDbPort dbPort;
	
	PayExpressionDeleteService(PayExpressionCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);
	}
}
