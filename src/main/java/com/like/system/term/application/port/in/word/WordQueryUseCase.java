package com.like.system.term.application.port.in.word;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.system.term.application.dto.word.WordSaveDTO;

@PrimaryPort
public interface WordQueryUseCase {
	List<WordSaveDTO> select();
}
