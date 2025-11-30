package com.like.system.term.application.service.domain;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.application.port.in.domain.DataDomainDeleteUseCase;
import com.like.system.term.application.port.out.DataDomainCommandDbPort;

@Transactional
@Application
@Service
public class DataDomainDeleteService implements DataDomainDeleteUseCase {

	DataDomainCommandDbPort dbPort;
	
	DataDomainDeleteService(DataDomainCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	@Override
	public void delete(String id) {
		this.dbPort.delete(id);
	}

}
