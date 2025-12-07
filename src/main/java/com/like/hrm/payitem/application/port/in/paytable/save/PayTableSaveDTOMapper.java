package com.like.hrm.payitem.application.port.in.paytable.save;

import com.like.hrm.payitem.domain.paytable.PayTable;

public class PayTableSaveDTOMapper {

	public static PayTableSaveDTO toDTO(PayTable entity) {
		if (entity == null) return null;
				
		return PayTableSaveDTO
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
	
	public static PayTable newEnity(PayTableSaveDTO dto) {
		return new PayTable(
				dto.companyCode(),
				dto.payItemCode(),
				dto.effectiveDate(),
				dto.occupationCode(),
				dto.jobGradeCode(),
				dto.payStepCode(),
				dto.wageAmount(),
				dto.isEnable(),
				dto.comment()
				);
	}
	
	public static PayTable modify(PayTable entity, PayTableSaveDTO dto) {
		entity.modify(
				dto.wageAmount(), 
				dto.isEnable(), 
				dto.comment()
				);
		
		return entity;
	}
	
}
