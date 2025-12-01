package com.like.system.term.application.port.in.term;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface TermSelectUseCase {
	TermSaveDTO select(String id);
}
