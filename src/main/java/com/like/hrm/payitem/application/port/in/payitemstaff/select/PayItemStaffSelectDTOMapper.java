package com.like.hrm.payitem.application.port.in.payitemstaff.select;

import com.like.hrm.payitem.domain.payitemstaff.PayItemStaff;

public class PayItemStaffSelectDTOMapper {

	public static PayItemStaffSelectDTO toDTO(PayItemStaff entity) {
		if (entity == null) return null;
				
		return PayItemStaffSelectDTO
				.builder()
				.id(entity.getId().toString())
				.companyCode(entity.getCompanyCode())
				.staffNo(entity.getStaffNo())
				.payItemCode(entity.getPayItemCode())
				.fromDt(entity.getPriod().from())
				.toDt(entity.getPriod().to())
				.wageAmount(entity.getWageAmount())				
				.comment(entity.getComment())
				.build();
	}
	
	
}
