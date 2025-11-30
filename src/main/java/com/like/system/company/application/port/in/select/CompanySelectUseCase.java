package com.like.system.company.application.port.in.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import jakarta.annotation.Nullable;

@PrimaryPort
public interface CompanySelectUseCase {
	@Nullable CompanySelectDTO select(String companyCode);
}
