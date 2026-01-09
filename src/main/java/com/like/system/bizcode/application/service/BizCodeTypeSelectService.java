package com.like.system.bizcode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.bizcode.application.port.in.type.select.BizCodeTypeSelectDTO;
import com.like.system.bizcode.application.port.in.type.select.BizCodeTypeSelectDTOMapper;
import com.like.system.bizcode.application.port.in.type.select.BizCodeTypeSelectUseCase;
import com.like.system.bizcode.application.port.out.BizCodeTypeCommandDbPort;

@Application
@Service
public class BizCodeTypeSelectService implements BizCodeTypeSelectUseCase {

	BizCodeTypeCommandDbPort port;
	
	public BizCodeTypeSelectService(BizCodeTypeCommandDbPort port) {
		this.port = port;
	}

	@Override
	public BizCodeTypeSelectDTO select(String companyCode, String typeId) {
		return BizCodeTypeSelectDTOMapper.toDTO(this.port.select(companyCode, typeId).orElse(null));
	}
	
}
