package com.like.hrm.payitem.application.port.in.payitem.save;

import com.like.hrm.payitem.domain.payitem.PayItem;
import com.like.hrm.payitem.domain.payitem.PayItemId;

public class PayItemSaveDTOMapper {

	public static PayItemSaveDTO toDTO(PayItem entity) {
		
		if (entity == null) return null;
		
		return PayItemSaveDTO
				.builder()
				.companyCode(entity.getId().getCompanyCode())
				.payItemCode(entity.getId().getPayItemCode())
				.payItemName(entity.getPayItemName())
				.type(entity.getType())
				.usePayTable(entity.getUsePayTable())
				.seq(entity.getSeq())
				.comment(entity.getComment())
				.build(); 		
	}
	
	public static PayItem newEntity(PayItemSaveDTO dto) {
		
		return new PayItem(
				new PayItemId(dto.companyCode(), dto.payItemCode()),
				dto.payItemName(),
				dto.type(),
				dto.usePayTable(),
				dto.seq(),
				dto.comment()
				);
	}
	
	public static PayItem modifyEntity(PayItem entity, PayItemSaveDTO dto) {
		entity.modify(
				dto.payItemName(), 
				dto.type(),
				dto.usePayTable(),
				dto.seq(),
				dto.comment()
				);
		
		return entity;
	}
}
