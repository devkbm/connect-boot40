package com.like.system.bizcode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.bizcode.application.port.in.code.save.BizCodeSaveDTO;
import com.like.system.bizcode.application.port.in.code.save.BizCodeSaveDTOMapper;
import com.like.system.bizcode.application.port.in.code.save.BizCodeSaveUseCase;
import com.like.system.bizcode.application.port.out.BizCodeCommandDbPort;
import com.like.system.bizcode.application.port.out.BizCodeTypeCommandDbPort;
import com.like.system.bizcode.domain.BizCodeType;

@Application
@Service
public class BizCodeSaveService implements BizCodeSaveUseCase {

	BizCodeCommandDbPort port;
	BizCodeTypeCommandDbPort bizCodeTypeDbPort;
	
	public BizCodeSaveService(BizCodeCommandDbPort port, BizCodeTypeCommandDbPort bizCodeTypeDbPort) {	
		this.port = port;
		this.bizCodeTypeDbPort = bizCodeTypeDbPort;
	}
	
	@Override
	public void save(BizCodeSaveDTO dto) {
		BizCodeType bizCodeType = this.bizCodeTypeDbPort.select(dto.companyCode(), dto.typeId()).orElse(null);
		this.port.save(BizCodeSaveDTOMapper.toEntity(dto, bizCodeType));
	}
	
}
