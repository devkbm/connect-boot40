package com.like.hrm.staff.application.port.in.staff.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffQueryUseCase {

	List<StaffQueryResultDTO> getStaffList(StaffQueryDTO dto);
	
	StaffCurrentAppointmentQueryResultDTO getStaffCurrentAppointment(String companyCode, String staffNo);
}
