package com.like.system.term.application.port.in.word;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WordSaveUseCase {
	void save(WordSaveDTO dto);
}
