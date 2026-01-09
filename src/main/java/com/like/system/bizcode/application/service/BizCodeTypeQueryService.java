package com.like.system.bizcode.application.service;

import java.util.List;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.bizcode.application.port.in.type.query.BizCodeTypeQueryResultDTO;
import com.like.system.bizcode.application.port.in.type.query.BizCodeTypeQueryUseCase;
import com.like.system.bizcode.application.port.out.BizCodeTypeQueryDbPort;

@Application
@Service
public class BizCodeTypeQueryService implements BizCodeTypeQueryUseCase {

	BizCodeTypeQueryDbPort port;
	
	public BizCodeTypeQueryService(BizCodeTypeQueryDbPort port) {
		this.port = port;
	}

	@Override
	public List<BizCodeTypeQueryResultDTO> select(String companyCode) {
		return this.port.select(companyCode);
	}
	
}
