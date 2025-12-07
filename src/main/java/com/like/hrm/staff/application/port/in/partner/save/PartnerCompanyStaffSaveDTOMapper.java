package com.like.hrm.staff.application.port.in.partner.save;

import com.like.hrm.staff.domain.partner.PartnerCompanyStaff;
import com.like.hrm.staff.domain.staff.StaffName;
import com.like.hrm.staff.domain.staff.StaffNoCreateStrategy;

public class PartnerCompanyStaffSaveDTOMapper {

	public static PartnerCompanyStaff create(PartnerCompanyStaffSaveDTO dto) {
		
		StaffNoCreateStrategy strategy = () -> dto.staffNo();
		
		return new PartnerCompanyStaff(
				dto.companyCode(), 
				strategy, 
				new StaffName(dto.name(), dto.nameEng(), dto.nameEng()), 
				dto.gender(),
				dto.birthday(),
				dto.partnerCompanyCode(),
				dto.joinDate(),
				dto.retireDate(),
				dto.blngDeptCode(),
				dto.workDeptCode()
				);
	}
	
	public static void modify(PartnerCompanyStaff entity, PartnerCompanyStaffSaveDTO dto) {
		entity.modify(
				new StaffName(dto.name(), dto.nameEng(), dto.nameEng()), 
				dto.gender(),
				dto.birthday(),
				dto.partnerCompanyCode(),
				dto.joinDate(),
				dto.retireDate(),
				dto.blngDeptCode(),
				dto.workDeptCode()
				);
	}	
	
}
