package com.like.hrm.staff.application.port.in.staff.dutyresponsibility.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffDutyResponsibilitySelectUseCase {
	
	StaffDutyResponsibilitySelectDTO select(String companyCode, String staffNo, Long seq);
}
