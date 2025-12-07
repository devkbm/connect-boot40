package com.like.hrm.staff.application.port.in.partner;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PartnerCompanyStaffDeleteUseCase {
	void delete(String companyCode, String staffNo);
}
