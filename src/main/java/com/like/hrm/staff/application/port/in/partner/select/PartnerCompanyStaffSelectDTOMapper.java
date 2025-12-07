package com.like.hrm.staff.application.port.in.partner.select;

import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;

public class PartnerCompanyStaffSelectDTOMapper {
	
	public static PartnerCompanyStaffSelectDTO toDTO(PartnerCompanyStaff entity) {
		if (entity == null) return null;
		
		return PartnerCompanyStaffSelectDTO
				.builder()
				.companyCode(entity.getId().companyCode())
				.staffNo(entity.getId().staffNo())
				.name(entity.getName().getName())
				.nameEng(entity.getName().getNameEng())
				.nameChi(entity.getName().getNameChi())
				.gender(entity.getGender())
				.birthday(entity.getBirthday())
				.partnerCompanyCode(entity.getPartnerCompanyCode())
				.joinDate(entity.getJoinDate())
				.retireDate(entity.getRetireDate())
				.blngDeptCode(entity.getBlngDeptCode())
				.workDeptCode(entity.getWorkDeptCode())
				.build(); 
	}	
	
}
