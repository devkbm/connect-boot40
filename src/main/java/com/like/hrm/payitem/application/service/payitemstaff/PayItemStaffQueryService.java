package com.like.hrm.payitem.application.service.payitemstaff;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryResultDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryUseCase;
import com.like.hrm.payitem.application.port.out.PayItemStaffQueryDbPort;

@Service
public class PayItemStaffQueryService implements PayItemStaffQueryUseCase {

	PayItemStaffQueryDbPort dbPort;
	
	PayItemStaffQueryService(PayItemStaffQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<PayItemStaffQueryResultDTO> query(PayItemStaffQueryDTO dto) {
		return this.dbPort.query(dto);
	}

}
