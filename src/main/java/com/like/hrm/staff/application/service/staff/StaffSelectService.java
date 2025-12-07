package com.like.hrm.staff.application.service.staff;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.port.in.staff.StaffSelectDTO;
import com.like.hrm.staff.application.port.in.staff.StaffSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;

@Application
@Service
public class StaffSelectService implements StaffSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public StaffSelectDTO select(String companyCode, String staffNo) {
		return StaffSelectDTO.toDTO(this.dbPort.select(companyCode, staffNo).orElse(null));
	}
	
}
