package com.like.hrm.payitem.application.service.paytable;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.paytable.select.PayTableSelectDTO;
import com.like.hrm.payitem.application.port.in.paytable.select.PayTableSelectDTOMapper;
import com.like.hrm.payitem.application.port.in.paytable.select.PayTableSelectUseCase;
import com.like.hrm.payitem.application.port.out.PayTableCommandDbPort;

@Service
public class PayTableSelectService implements PayTableSelectUseCase {

	PayTableCommandDbPort dbPort;
	
	PayTableSelectService(PayTableCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public PayTableSelectDTO select(Long id) {		
		return PayTableSelectDTOMapper.toDTO(this.dbPort.select(id).orElse(null));
	}

}
