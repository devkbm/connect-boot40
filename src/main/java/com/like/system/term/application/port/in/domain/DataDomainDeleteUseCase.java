package com.like.system.term.application.port.in.domain;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface DataDomainDeleteUseCase {
	void delete(String id);
}
