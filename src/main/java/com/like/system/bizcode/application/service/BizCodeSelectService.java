package com.like.system.bizcode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.bizcode.application.port.in.code.select.BizCodeSelectDTO;
import com.like.system.bizcode.application.port.in.code.select.BizCodeSelectDTOMapper;
import com.like.system.bizcode.application.port.in.code.select.BizCodeSelectUseCase;
import com.like.system.bizcode.application.port.out.BizCodeCommandDbPort;

@Application
@Service
public class BizCodeSelectService implements BizCodeSelectUseCase {
	
	BizCodeCommandDbPort port;
	
	public BizCodeSelectService(BizCodeCommandDbPort port) {		
		this.port = port;
	}
	
	@Override
	public BizCodeSelectDTO select(String companyCode, String typeId, String code) {						
		return BizCodeSelectDTOMapper.toDTO(this.port.select(companyCode, typeId, code).orElse(null));
	}
	
}
