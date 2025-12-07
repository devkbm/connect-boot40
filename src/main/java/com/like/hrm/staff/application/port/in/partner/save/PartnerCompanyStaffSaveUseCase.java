package com.like.hrm.staff.application.port.in.partner.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface PartnerCompanyStaffSaveUseCase {

	void save(PartnerCompanyStaffSaveDTO dto);
}
