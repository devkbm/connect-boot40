package com.like.system.term.application.port.in.word;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WordQueryUseCase {
	List<WordSaveDTO> select();
}
