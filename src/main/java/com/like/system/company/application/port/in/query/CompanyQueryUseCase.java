package com.like.system.company.application.port.in.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface CompanyQueryUseCase {

	List<CompanyQueryResultDTO> query();
}
