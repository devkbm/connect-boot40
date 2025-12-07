package com.like.hrm.payitem.application.port.in.payitem.select;

import com.like.hrm.payitem.domain.payitem.PayItem;

public class PayItemSelectDTOMapper {

	public static PayItemSelectDTO toDTO(PayItem entity) {
		
		if (entity == null) return null;
		
		return PayItemSelectDTO
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
	
}
