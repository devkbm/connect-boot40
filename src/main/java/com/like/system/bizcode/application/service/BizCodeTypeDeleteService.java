package com.like.system.bizcode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.bizcode.application.port.in.type.delete.BizCodeTypeDeleteUseCase;
import com.like.system.bizcode.application.port.out.BizCodeTypeCommandDbPort;

@Application
@Service
public class BizCodeTypeDeleteService implements BizCodeTypeDeleteUseCase {

	BizCodeTypeCommandDbPort port;
	
	BizCodeTypeDeleteService(BizCodeTypeCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String typeId) {
		this.port.delete(companyCode, typeId);		
	}
	
	
}
