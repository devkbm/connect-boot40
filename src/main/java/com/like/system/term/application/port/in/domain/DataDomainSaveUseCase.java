package com.like.system.term.application.port.in.domain;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface DataDomainSaveUseCase {
	void save(DataDomainSaveDTO dto);
}
