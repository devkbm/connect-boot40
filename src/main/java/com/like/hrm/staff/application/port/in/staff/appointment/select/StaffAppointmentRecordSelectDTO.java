package com.like.hrm.staff.application.port.in.staff.appointment.select;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PACKAGE)
public record StaffAppointmentRecordSelectDTO(
		String clientAppUrl,
		String companyCode,
		@NotEmpty			
		String staffNo,
		String staffName,			
		Long seq,
		String appointmentTypeCode,
		String applyType,
		LocalDate appointmentDate,
		LocalDate appointmentEndDate,			
		String recordName,
		String comment,				
		Boolean isCompleted,
		String blngDeptCode,			
		String workDeptCode,			
		String jobGroupCode,			
		String jobPositionCode,			
		String occupationCode,			
		String jobGradeCode,
		String payStepCode,			
		String jobCode,			
		List<String> dutyResponsibilityCode
		) {
	
}
