package com.like.hrm.staff.application.port.in.staff.family.save;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.family.StaffFamily;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record StaffFamilySaveDTO(
		String clientAppUrl,
		String companyCode,			
		@NotEmpty String staffNo,
		String staffName,
		Long seq,
		String familyName,
		String familyRRN,
		String familyRelation,
		String occupation,
		String schoolCareerType,
		String comment
		) {
	
	public StaffFamily newEntity(Staff staff) {
		StaffFamily entity = StaffFamily.builder()
										.staff(staff)
										.name(familyName)
										.residentRegistrationNumber(familyRRN)
										.relation(familyRelation)
										.occupation(occupation)
										.schoolCareerType(schoolCareerType)
										.comment(comment)
										.build();
		entity.createdAppUrl(clientAppUrl);
		return entity; 							
	}
	
	public void modifyEntity(StaffFamily entity) {
		entity.modifyBuilder()
		      .name(familyName)
		      .residentRegistrationNumber(familyRRN)
		      .relation(familyRelation)
		      .occupation(occupation)
		      .schoolCareerType(schoolCareerType)
		      .comment(comment)
		      .modify();		
		
		entity.createdAppUrl(clientAppUrl);
	}
	
	public static StaffFamilySaveDTO toDTO(StaffFamily entity) {
		if (entity == null) return null;
		
		return StaffFamilySaveDTO.builder()		
				   .companyCode(entity.staff().id().companyCode())
				   .staffNo(entity.staff().id().staffNo())
				   .staffName(entity.staff().name().getName())
				   .seq(entity.id().seq())
				   .familyName(entity.name())
				   .familyRRN(entity.residentRegistrationNumber())
				   .familyRelation(entity.relation())
				   .occupation(entity.occupation())
				   .schoolCareerType(entity.schoolCareerType())
				   .comment(entity.comment())
				   .build();									 							 							 							 					
	}
}