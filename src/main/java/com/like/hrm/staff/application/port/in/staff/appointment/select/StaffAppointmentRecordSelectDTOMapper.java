package com.like.hrm.staff.application.port.in.staff.appointment.select;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.appointment.AppointmentInformation;
import com.like.hrm.staff.domain.staff.appointment.AppointmentRecord;

public class StaffAppointmentRecordSelectDTOMapper {
	
			
	public static StaffAppointmentRecordSelectDTO toDTO(AppointmentRecord entity) {
		if (entity == null) return null;																													

		Optional<AppointmentInformation> info = Optional.ofNullable(entity.info());
		
		return StaffAppointmentRecordSelectDTO
				.builder()											 
				.staffNo(entity.staff().id().staffNo())
				.staffName(entity.staff().name().getName())
				.seq(entity.id().seq())
				.appointmentTypeCode(entity.appointmentTypeCode())
				.applyType(entity.applyType().getCode())
				.appointmentDate(entity.appointmentDate())
				.appointmentEndDate(entity.appointmentEndDate())
				.recordName(entity.recordName())
				.comment(entity.comment())
				.isCompleted(entity.isCompleted())
				.blngDeptCode(info.map(AppointmentInformation::getBlngDeptCode).orElse(null))
				.workDeptCode(info.map(AppointmentInformation::getWorkDeptCode).orElse(null))
				.jobGroupCode(info.map(AppointmentInformation::getJobGroupCode).orElse(null))
				.jobPositionCode(info.map(AppointmentInformation::getJobPositionCode).orElse(null))
				.occupationCode(info.map(AppointmentInformation::getOccupationCode).orElse(null))
				.jobGradeCode(info.map(AppointmentInformation::getJobGradeCode).orElse(null))
				.payStepCode(info.map(AppointmentInformation::getPayStepCode).orElse(null))
				.jobCode(info.map(AppointmentInformation::getJobCode).orElse(null))
				.dutyResponsibilityCode(info.map(AppointmentInformation::getDutyResponsibilityCode).orElse(null))
				.build();									
	}
		
}
