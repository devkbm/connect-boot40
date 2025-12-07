package com.like.hrm.staff.application.port.in.staff.license.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffLicenseSelectUseCase {	
	StaffLicenseSelectDTO select(String companyCode, String staffNo, Long seq);
}
