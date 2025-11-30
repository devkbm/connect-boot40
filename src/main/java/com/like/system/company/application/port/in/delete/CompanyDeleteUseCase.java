package com.like.system.company.application.port.in.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface CompanyDeleteUseCase {
	void delete(String companyCode);
}
