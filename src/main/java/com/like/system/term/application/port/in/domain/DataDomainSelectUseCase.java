package com.like.system.term.application.port.in.domain;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.system.term.application.dto.domain.DataDomainSaveDTO;

@PrimaryPort
public interface DataDomainSelectUseCase {
	DataDomainSaveDTO select(String id);
	
}
