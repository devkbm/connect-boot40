package com.like.hrm.payitem.application.service.paytable;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryDTO;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryResultDTO;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryUseCase;
import com.like.hrm.payitem.application.port.out.PayTableQueryDbPort;

@Service
public class PayTableQueryService implements PayTableQueryUseCase {

	PayTableQueryDbPort dbPort;
	
	PayTableQueryService(PayTableQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<PayTableQueryResultDTO> query(PayTableQueryDTO dto) {
		return this.dbPort.query(dto);
	}

}
