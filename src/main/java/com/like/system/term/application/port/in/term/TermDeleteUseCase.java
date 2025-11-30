package com.like.system.term.application.port.in.term;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface TermDeleteUseCase {
	void delete(String id);
}
