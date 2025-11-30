package com.like.system.term.application.port.out;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.term.domain.TermDictionary;

@SecondaryPort
public interface TermCommandDbPort {

	TermDictionary select(String id);
	
	void save(TermDictionary entity);
	
	void delete(String id);
}
