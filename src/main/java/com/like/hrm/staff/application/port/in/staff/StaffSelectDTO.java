package com.like.hrm.staff.application.port.in.staff;

import java.time.LocalDate;

import com.like.hrm.staff.domain.staff.Staff;

public record StaffSelectDTO(			
		String companyCode,
		String staffNo,
		String name,
		String nameEng,
		String nameChi,
		String residentRegistrationNumber,
		String gender,
		LocalDate birthday,
		String imagePath
		) {
			
	public static StaffSelectDTO toDTO(Staff entity) {
		
		if (entity == null) return null;			
		
		var name = entity.name();
		
		return new StaffSelectDTO(
				entity.id().companyCode(),
				entity.id().staffNo(),
				name.getName(),
				name.getNameEng(),
				name.getNameChi(),
				entity.residentRegistrationNumber().getNumber(),
				entity.gender(),
				entity.birthday(),
				entity.imagePath()
				);								   							  
	}
}