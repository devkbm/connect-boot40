package com.like.hrm.payitem.application.service.payitemstaff;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitemstaff.select.PayItemStaffSelectDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.select.PayItemStaffSelectDTOMapper;
import com.like.hrm.payitem.application.port.in.payitemstaff.select.PayItemStaffSelectUseCase;
import com.like.hrm.payitem.application.port.out.PayItemStaffCommandDbPort;

@Service
public class PayItemStaffSelectService implements PayItemStaffSelectUseCase {

	PayItemStaffCommandDbPort dbPort;
	
	PayItemStaffSelectService(PayItemStaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public PayItemStaffSelectDTO select(Long id) {			
		return PayItemStaffSelectDTOMapper.toDTO(
				this.dbPort.select(id).orElse(null)
				);
	}

}
