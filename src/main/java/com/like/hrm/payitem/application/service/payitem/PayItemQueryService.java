package com.like.hrm.payitem.application.service.payitem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryDTO;
import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryResultDTO;
import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryUseCase;
import com.like.hrm.payitem.application.port.out.PayItemQueryDbPort;

@Service
public class PayItemQueryService implements PayItemQueryUseCase {

	PayItemQueryDbPort dbPort;
	
	PayItemQueryService(PayItemQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<PayItemQueryResultDTO> query(PayItemQueryDTO dto) {
		return this.dbPort.query(dto);
	}

}
