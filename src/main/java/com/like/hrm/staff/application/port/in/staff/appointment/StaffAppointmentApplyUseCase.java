package com.like.hrm.staff.application.port.in.staff.appointment;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffAppointmentApplyUseCase {
	void apply(String companyCode, String staffNo, Long seq);
}
