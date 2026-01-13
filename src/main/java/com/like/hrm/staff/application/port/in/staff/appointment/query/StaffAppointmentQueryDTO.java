package com.like.hrm.staff.application.port.in.staff.appointment.query;

import java.time.LocalDate;

public record StaffAppointmentQueryDTO(
		String companyCode,
		String staffNo,
		String appointmentTypeCode,
		LocalDate from,
		LocalDate to		
		) {

}
