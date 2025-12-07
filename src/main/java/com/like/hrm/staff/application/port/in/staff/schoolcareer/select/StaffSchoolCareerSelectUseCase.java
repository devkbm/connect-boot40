package com.like.hrm.staff.application.port.in.staff.schoolcareer.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffSchoolCareerSelectUseCase {	
	StaffSchoolCareerSelectDTO select(String companyCode, String staffNo, Long seq);
}
