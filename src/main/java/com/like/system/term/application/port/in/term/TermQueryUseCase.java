package com.like.system.term.application.port.in.term;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface TermQueryUseCase {
	List<TermSelectDTO> select(TermQueryDTO dto);
}
