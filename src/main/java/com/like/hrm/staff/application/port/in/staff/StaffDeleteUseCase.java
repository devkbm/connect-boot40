package com.like.hrm.staff.application.port.in.staff;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffDeleteUseCase {
	void delete(String companyCode, String staffNo);
}
