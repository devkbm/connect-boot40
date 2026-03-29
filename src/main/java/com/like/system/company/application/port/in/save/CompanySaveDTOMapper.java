package com.like.system.company.application.port.in.save;

import com.like.system.company.domain.CompanyInfo;

public class CompanySaveDTOMapper {

	public static CompanyInfo toEntity(CompanySaveDTO dto) {
		return new CompanyInfo(
				dto.clientAppUrl(),
				dto.companyCode(),
				dto.companyName(),
				dto.businessRegistrationNumber(),
				dto.coporationNumber(),
				dto.nameOfRepresentative(),
				dto.establishmentDate()
				);
	}
	
	public static CompanySaveDTO toDTO(CompanyInfo entity) {		
		
		return CompanySaveDTO
				.builder()
				.companyCode(entity.id().companyCode())
				.companyName(entity.companyName())
				.businessRegistrationNumber(entity.businessRegistrationNumber())
				.coporationNumber(entity.coporationNumber())
				.nameOfRepresentative(entity.nameOfRepresentative())
				.establishmentDate(entity.establishmentDate())
				.build();
					
	}
}
