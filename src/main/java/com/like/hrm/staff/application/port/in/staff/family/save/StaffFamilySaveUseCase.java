package com.like.hrm.staff.application.port.in.staff.family.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffFamilySaveUseCase {
	void save(StaffFamilySaveDTO dto);
}
