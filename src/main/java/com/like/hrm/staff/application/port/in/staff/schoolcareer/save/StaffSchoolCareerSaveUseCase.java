package com.like.hrm.staff.application.port.in.staff.schoolcareer.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffSchoolCareerSaveUseCase {
	void save(StaffSchoolCareerSaveDTO dto);
}
