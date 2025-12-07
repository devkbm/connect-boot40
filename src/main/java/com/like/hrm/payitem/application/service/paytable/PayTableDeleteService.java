package com.like.hrm.payitem.application.service.paytable;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.paytable.delete.PayTableDeleteUseCase;
import com.like.hrm.payitem.application.port.out.PayTableCommandDbPort;

@Service
public class PayTableDeleteService implements PayTableDeleteUseCase {

	PayTableCommandDbPort dbPort;
	
	PayTableDeleteService(PayTableCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}

}
