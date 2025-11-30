package com.like.system.term.application.service.domain;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.term.application.dto.domain.DataDomainSaveDTO;
import com.like.system.term.application.dto.domain.DataDomainSaveDTOMapper;
import com.like.system.term.application.port.in.domain.DataDomainSelectUseCase;
import com.like.system.term.application.port.out.DataDomainCommandDbPort;

@Application
@Service
public class DataDomainSelectService implements DataDomainSelectUseCase {

	DataDomainCommandDbPort dbPort;
	
	DataDomainSelectService(DataDomainCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public DataDomainSaveDTO select(String id) {
		return DataDomainSaveDTOMapper.toDTO(this.dbPort.select(id));
	}
}
