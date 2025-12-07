package com.like.hrm.staff.application.port.in.staff.appointment.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffAppointmentSelectUseCase {
	StaffAppointmentRecordSelectDTO select(String companyCode, String staffNo, Long seq);	
}
