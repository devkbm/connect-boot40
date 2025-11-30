package com.like.system.term.application.port.in.domain;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.system.term.application.dto.domain.DataDomainSaveDTO;

@PrimaryPort
public interface DataDomainSaveUseCase {
	void save(DataDomainSaveDTO dto);
}
