package com.like.system.term.application.port.in.term;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface TermSaveUseCase {
	void save(TermSaveDTO dto);
}
