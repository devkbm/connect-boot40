package com.like.system.bizcode.application.port.in.code.select;

import com.like.system.bizcode.domain.BizCode;

public class BizCodeSelectDTOMapper {
	
	public static BizCodeSelectDTO toDTO(BizCode entity) {
		return BizCodeSelectDTO
				.builder()
				.companyCode(entity.getBizCodeType().getId().getCompanyCode())
				.typeId(entity.getBizCodeType().getId().getTypeId())
				.code(entity.getId().getCode())
				.codeName(entity.getCodeName())
				.useYn(entity.getUseYn())
				.sequence(entity.getSequence())
				.comment(entity.getComment())
				.build();
	}
	
}
