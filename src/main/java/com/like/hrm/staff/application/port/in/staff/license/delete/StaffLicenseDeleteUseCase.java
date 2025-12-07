package com.like.hrm.staff.application.port.in.staff.license.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffLicenseDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
