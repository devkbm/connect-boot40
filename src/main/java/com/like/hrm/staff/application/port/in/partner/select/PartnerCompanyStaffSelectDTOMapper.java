package com.like.hrm.staff.application.port.in.partner.select;

import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;

public class PartnerCompanyStaffSelectDTOMapper {
	
	public static PartnerCompanyStaffSelectDTO toDTO(PartnerCompanyStaff entity) {
		if (entity == null) return null;
		
		return PartnerCompanyStaffSelectDTO
				.builder()
				.companyCode(entity.id().companyCode())
				.staffNo(entity.id().staffNo())
				.name(entity.name().getName())
				.nameEng(entity.name().getNameEng())
				.nameChi(entity.name().getNameChi())
				.gender(entity.gender())
				.birthday(entity.birthday())
				.partnerCompanyCode(entity.partnerCompanyCode())
				.joinDate(entity.joinDate())
				.retireDate(entity.retireDate())
				.blngDeptCode(entity.blngDeptCode())
				.workDeptCode(entity.workDeptCode())
				.build(); 
	}	
	
}
