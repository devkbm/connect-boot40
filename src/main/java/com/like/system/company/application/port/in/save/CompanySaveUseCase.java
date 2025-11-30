package com.like.system.company.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface CompanySaveUseCase {
	void save(CompanySaveDTO dto); 
}
