package com.like.hrm.staff.application.port.in.staff.schoolcareer.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffSchoolCareerDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
