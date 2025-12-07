package com.like.hrm.payitem.application.service.payitemstaff;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitemstaff.delete.PayItemStaffDeleteUseCase;
import com.like.hrm.payitem.application.port.out.PayItemStaffCommandDbPort;

@Service
public class PayItemStaffDeleteService implements PayItemStaffDeleteUseCase {

	PayItemStaffCommandDbPort dbPort;
	
	PayItemStaffDeleteService(PayItemStaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}

}
