package com.like.hrm.staff.application.port.in.staff.dutyresponsibility.select;

import java.time.LocalDate;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record StaffDutyResponsibilitySelectDTO(
		String clientAppUrl,
		String companyCode,			
		String staffNo,
		String staffName,
		Long seq,
		String dutyResponsibilityCode,
		String dutyResponsibilityName,
		LocalDate fromDate,
		LocalDate toDate,
		Boolean isPayApply			
		) {
	
	public StaffDuty newEntity(Staff staff) {		
		StaffDuty entity = StaffDuty.builder()
									.staff(staff)
									.dutyResponsibilityCode(dutyResponsibilityCode)
									.fromDate(fromDate)
									.toDate(toDate)
									.isPayApply(isPayApply)
									.build(); 									
							
		entity.createdAppUrl(clientAppUrl);
		
		return entity;
	}
	
	public void modifyEntity(StaffDuty entity) {
		entity.modifyBuilder()
			  .dutyResponsibilityCode(dutyResponsibilityCode)
			  .fromDate(fromDate)
			  .toDate(toDate)
			  .isPayApply(isPayApply)
			  .modify();
		
		//entity.modifyEntity(dutyResponsibilityCode, fromDate, toDate, isPayApply);
		
		entity.createdAppUrl(clientAppUrl);
	}
	
	
	public static StaffDutyResponsibilitySelectDTO toDTO(StaffDuty entity) {			
		if (entity == null) return null;
		
		return StaffDutyResponsibilitySelectDTO.builder()
				   .companyCode(entity.staff().id().companyCode())
				   .staffNo(entity.staff().id().staffNo())
				   .staffName(entity.staff().name().getName())
				   .seq(entity.id().seq())
				   .dutyResponsibilityCode(entity.dutyResponsibilityCode())
				   .dutyResponsibilityName(entity.dutyResponsibilityCode())
				   .fromDate(entity.fromDate())
				   .toDate(entity.toDate())
				   .isPayApply(entity.isPayApply())
				   .build();
	}
	
}