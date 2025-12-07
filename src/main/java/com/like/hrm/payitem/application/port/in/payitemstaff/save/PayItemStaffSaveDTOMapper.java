package com.like.hrm.payitem.application.port.in.payitemstaff.save;

import com.like.common.vo.LocalDatePeriod;
import com.like.hrm.payitem.domain.payitemstaff.PayItemStaff;

public class PayItemStaffSaveDTOMapper {

	public static PayItemStaffSaveDTO toDTO(PayItemStaff entity) {
		if (entity == null) return null;
				
		return PayItemStaffSaveDTO
				.builder()
				.id(entity.getId().toString())
				.companyCode(entity.getCompanyCode())
				.staffNo(entity.getStaffNo())
				.payItemCode(entity.getPayItemCode())
				.fromDt(entity.getPriod().getFrom())
				.toDt(entity.getPriod().getTo())
				.wageAmount(entity.getWageAmount())				
				.comment(entity.getComment())
				.build();
	}
	
	public static PayItemStaff newEnity(PayItemStaffSaveDTO dto) {
		return new PayItemStaff(	
				dto.companyCode(),
				dto.staffNo(),
				dto.payItemCode(),
				new LocalDatePeriod(dto.fromDt(), dto.toDt()),
				dto.wageAmount(),				
				dto.comment()
				);
	}
	
	public static PayItemStaff modify(PayItemStaff entity, PayItemStaffSaveDTO dto) {
		entity.modify(
				dto.payItemCode(),
				new LocalDatePeriod(dto.fromDt(), dto.toDt()),
				dto.wageAmount(),				
				dto.comment()
				);
		
		return entity;
	}
	
}
