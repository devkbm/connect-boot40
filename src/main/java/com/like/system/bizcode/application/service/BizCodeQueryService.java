package com.like.system.bizcode.application.service;

import java.util.List;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.bizcode.application.port.in.code.query.BizCodeQueryResultDTO;
import com.like.system.bizcode.application.port.in.code.query.BizCodeQueryUseCase;
import com.like.system.bizcode.application.port.out.BizCodeQueryDbPort;

@Application
@Service
@Transactional(readOnly = true)
public class BizCodeQueryService implements BizCodeQueryUseCase {

	BizCodeQueryDbPort dbPort;
	
	BizCodeQueryService(BizCodeQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
		
	@Override
	public List<BizCodeQueryResultDTO> query(String companyCode, String typeId) {
		return this.dbPort.query(companyCode, typeId);
	}
}
