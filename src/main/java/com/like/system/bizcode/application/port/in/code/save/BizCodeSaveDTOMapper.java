package com.like.system.bizcode.application.port.in.code.save;

import com.like.system.bizcode.domain.BizCode;
import com.like.system.bizcode.domain.BizCodeType;

public class BizCodeSaveDTOMapper {

	public static BizCode toEntity(BizCodeSaveDTO dto, BizCodeType bizCodeType) {		
		return BizCode.builder()
					  .bizCodeType(bizCodeType)
					  .code(dto.code())
					  .useYn(dto.useYn())
					  .name(dto.codeName())
					  .sequence(dto.sequence())
					  .code(dto.comment())
					  .build();
	}
}
