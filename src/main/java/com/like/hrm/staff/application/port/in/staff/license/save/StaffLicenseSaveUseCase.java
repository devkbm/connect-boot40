package com.like.hrm.staff.application.port.in.staff.license.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffLicenseSaveUseCase {

	void save(StaffLicenseSaveDTO dto);
}
