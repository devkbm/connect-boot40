package com.like.hrm.staff.application.port.in.staff;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffSelectUseCase {
	StaffSelectDTO select(String companyCode, String staffNo);
}
