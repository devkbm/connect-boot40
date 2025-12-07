package com.like.hrm.staff.application.port.in.staff.dutyresponsibility.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffDutyResponsibilitySaveUseCase {
	void save(StaffDutyResponsibilitySaveDTO dto);
}
