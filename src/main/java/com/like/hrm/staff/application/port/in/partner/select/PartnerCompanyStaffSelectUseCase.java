package com.like.hrm.staff.application.port.in.partner.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PartnerCompanyStaffSelectUseCase {

	PartnerCompanyStaffSelectDTO select(String companyCode, String staffNo);
}
