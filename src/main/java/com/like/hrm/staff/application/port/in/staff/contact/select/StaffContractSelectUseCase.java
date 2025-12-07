package com.like.hrm.staff.application.port.in.staff.contact.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffContractSelectUseCase {

	StaffContactSelectDTO select(String companyCode, String staffNo);
}
