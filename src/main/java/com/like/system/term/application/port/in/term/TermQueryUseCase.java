package com.like.system.term.application.port.in.term;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.system.term.application.dto.term.TermQueryDTO;
import com.like.system.term.application.dto.term.TermSaveDTO;

@PrimaryPort
public interface TermQueryUseCase {
	List<TermSaveDTO> select(TermQueryDTO dto);
}
