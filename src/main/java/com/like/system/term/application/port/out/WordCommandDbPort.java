package com.like.system.term.application.port.out;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.term.domain.WordDictionary;

@SecondaryPort
public interface WordCommandDbPort {

	WordDictionary select(String id);
	
	void save(WordDictionary entity);
	
	void delete(String id);
}
