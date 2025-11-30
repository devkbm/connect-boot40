package com.like.system.systemcode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.systemcode.application.port.in.delete.BizCodeDeleteUseCase;
import com.like.system.systemcode.application.port.out.BizCodeCommandDbPort;

@Application
@Service
public class BizCodeDeleteService implements BizCodeDeleteUseCase {

	BizCodeCommandDbPort port;
	
	public BizCodeDeleteService(BizCodeCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String typeId, String code) {
		this.port.delete(companyCode, typeId, code);		
	}

	
}
