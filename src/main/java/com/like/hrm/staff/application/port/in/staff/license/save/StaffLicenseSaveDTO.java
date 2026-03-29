package com.like.hrm.staff.application.port.in.staff.license.save;

import java.time.LocalDate;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.license.StaffLicense;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record StaffLicenseSaveDTO(
		String clientAppUrl,
		String companyCode,			
		@NotEmpty String staffNo,
		String staffName,
		Long seq,
		@NotEmpty String licenseType,
		@NotEmpty String licenseNumber,
		LocalDate dateOfAcquisition,
		String certificationAuthority,
		String comment
		) {
	
	public StaffLicense newEntity(Staff staff) {
		StaffLicense entity = StaffLicense.builder()
										  .staff(staff)
										  .licenseType(licenseType)
										  .licenseNumber(licenseNumber)
										  .dateOfAcquisition(dateOfAcquisition)
										  .certificationAuthority(certificationAuthority)
										  .comment(comment)
										  .build();
		entity.createdAppUrl(clientAppUrl);
		
		return entity; 			
	}
	
	public void modifyEntity(StaffLicense entity) {
		entity.modifyBuilder()			
		      .licenseType(licenseType)
		      .licenseNumber(licenseNumber)
		      .dateOfAcquisition(dateOfAcquisition)
		      .certificationAuthority(certificationAuthority)
		      .comment(comment)
			  .modify();
		
		entity.createdAppUrl(clientAppUrl);
	}	
	
	public static StaffLicenseSaveDTO toDTO(StaffLicense entity)  {
		if (entity == null) return null; 
		
		return StaffLicenseSaveDTO.builder()
				   .companyCode(entity.staff().id().companyCode())
				   .staffNo(entity.staff().id().staffNo())
				   .staffName(entity.staff().name().getName())
				   .seq(entity.id().seq())
				   .licenseType(entity.licenseType())
				   .licenseNumber(entity.licenseNumber())
				   .dateOfAcquisition(entity.dateOfAcquisition())
				   .certificationAuthority(entity.certificationAuthority())
				   .comment(entity.comment())
				   .build();			
	}
}