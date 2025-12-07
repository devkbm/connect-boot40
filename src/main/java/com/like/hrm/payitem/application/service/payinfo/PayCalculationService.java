package com.like.hrm.payitem.application.service.payinfo;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payinfo.PayCalculationUseCase;
import com.like.hrm.payitem.application.port.out.PayStaffInfoCommandDbPort;
import com.like.hrm.payitem.application.port.out.PayStaffItemCommandDbPort;

@Service
public class PayCalculationService implements PayCalculationUseCase {

	PayStaffInfoCommandDbPort payStaffInfoDbPort;
	PayStaffItemCommandDbPort payStaffItemDbPort;
	
	PayCalculationService(
			PayStaffInfoCommandDbPort payStaffInfoDbPort,
			PayStaffItemCommandDbPort payStaffItemDbPort
			) {
		this.payStaffInfoDbPort = payStaffInfoDbPort;
		this.payStaffItemDbPort = payStaffItemDbPort;
	}
	
	@Override
	public void calc(String companyCode, String payYm, String paySeq, String staffNo) {
		
		
	}

}
