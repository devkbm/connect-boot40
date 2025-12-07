package com.like.hrm.staff.application.port.in.staff.family.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffFamilyDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
