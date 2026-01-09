package com.like.system.bizcode.application.port.in.type.select;

import lombok.Builder;

@Builder
public record BizCodeTypeSelectDTO(
		String clientAppUrl,
		String companyCode,
		String typeId,			
		String typeName,			
		Integer sequence,
		String bizType,
		String comment
		) {

}
