package com.like.system.bizcode.application.port.in.type.save;

import com.like.system.bizcode.domain.BizCodeType;
import com.like.system.bizcode.domain.BizTypeEnum;

public class BizCodeTypeSaveDTOMapper {

	public static BizCodeType toEntity(BizCodeTypeSaveDTO dto) {
		return new BizCodeType(dto.companyCode()
							  ,dto.typeId()
							  ,dto.typeName()
							  ,BizTypeEnum.valueOf(dto.bizType())
							  ,dto.comment());		
	}
	
	
}
