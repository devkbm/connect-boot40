package com.like.system.term.application.port.in.domain;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface DataDomainQueryUseCase {
	List<DataDomainSaveDTO> selectList();
}
