package com.like.hrm.staff.application.port.in.staff.appointment.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffAppointmentQueryUseCase {
	List<StaffAppointmentQueryResultDTO> select(String companyCode, String staffNo);
}
