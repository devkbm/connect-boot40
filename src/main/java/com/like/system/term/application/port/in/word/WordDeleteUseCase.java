package com.like.system.term.application.port.in.word;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WordDeleteUseCase {
	void delete(String id);
}
