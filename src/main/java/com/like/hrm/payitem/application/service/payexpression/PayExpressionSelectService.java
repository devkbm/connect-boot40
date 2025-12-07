package com.like.hrm.payitem.application.service.payexpression;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payexpression.select.PayExpressionSelectDTO;
import com.like.hrm.payitem.application.port.in.payexpression.select.PayExpressionSelectDTOMapper;
import com.like.hrm.payitem.application.port.in.payexpression.select.PayExpressionSelectUseCase;
import com.like.hrm.payitem.application.port.out.PayExpressionCommandDbPort;

@Service
public class PayExpressionSelectService implements PayExpressionSelectUseCase {

	PayExpressionCommandDbPort dbPort;
	
	PayExpressionSelectService(PayExpressionCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public PayExpressionSelectDTO select(Long id) {		
		return PayExpressionSelectDTOMapper.toDTO(this.dbPort.select(id).orElse(null));
	}
	
	
}
