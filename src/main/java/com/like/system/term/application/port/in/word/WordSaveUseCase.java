package com.like.system.term.application.port.in.word;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.system.term.application.dto.word.WordSaveDTO;

@PrimaryPort
public interface WordSaveUseCase {
	void save(WordSaveDTO dto);
}
