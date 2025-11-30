package com.like.system.term.application.port.out;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.term.domain.DataDomainDictionary;

@SecondaryPort
public interface DataDomainCommandDbPort {
	DataDomainDictionary select(String id);
	
	void save(DataDomainDictionary entity);
	
	void delete(String id);
}
