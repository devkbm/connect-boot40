package com.like.hrm.payitem.application.port.in.paytable.select;

import com.like.hrm.payitem.domain.paytable.PayTable;

public class PayTableSelectDTOMapper {

	public static PayTableSelectDTO toDTO(PayTable entity) {
		if (entity == null) return null;
				
		return PayTableSelectDTO
				.builder()
				.id(entity.getId().toString())
				.companyCode(entity.getCompanyCode())
				.payItemCode(entity.getPayItemCode())
				.effectiveDate(entity.getEffectiveDate())
				.occupationCode(entity.getOccupationCode())
				.jobGradeCode(entity.getJobGradeCode())
				.payStepCode(entity.getPayStepCode())
				.wageAmount(entity.getWageAmount())
				.isEnable(entity.getIsEnable())
				.comment(entity.getComment())
				.build();
	}	
	
}
