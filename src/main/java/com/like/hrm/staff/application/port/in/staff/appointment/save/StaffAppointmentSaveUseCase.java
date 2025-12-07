package com.like.hrm.staff.application.port.in.staff.appointment.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffAppointmentSaveUseCase {
	void save(StaffAppointmentRecordDTO dto);	
}
