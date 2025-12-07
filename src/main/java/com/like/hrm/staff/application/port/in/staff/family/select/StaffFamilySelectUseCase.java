package com.like.hrm.staff.application.port.in.staff.family.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffFamilySelectUseCase {	
	StaffFamilySelectDTO select(String companyCode, String staffNo, Long seq);
}

