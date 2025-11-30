package com.like.system.term.application.port.in.term;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.system.term.application.dto.term.TermSaveDTO;

@PrimaryPort
public interface TermSelectUseCase {
	TermSaveDTO select(String id);
}
