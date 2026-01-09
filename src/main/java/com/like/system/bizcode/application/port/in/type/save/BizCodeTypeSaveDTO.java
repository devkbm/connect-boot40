package com.like.system.bizcode.application.port.in.type.save;

import lombok.Builder;

@Builder
public record BizCodeTypeSaveDTO(
		String clientAppUrl,
		String companyCode,
		String typeId,			
		String typeName,			
		Integer sequence,
		String bizType,
		String comment
		) {

}
