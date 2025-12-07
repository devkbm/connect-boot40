package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

@SecondaryPort
public interface StaffAppointmentCommandDbPort {
	Optional<AppointmentRecord> select(String companyCode, String staffNo, Long seq);	

	AppointmentRecord save(AppointmentRecord entity);
	
	void delete(String companyCode, String staffNo, Long seq);
}
