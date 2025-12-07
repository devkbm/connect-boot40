package com.like.hrm.staff.application.port.in.staff.contact.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffContractSaveUseCase {

	void save(StaffContactSaveDTO dto);
}
