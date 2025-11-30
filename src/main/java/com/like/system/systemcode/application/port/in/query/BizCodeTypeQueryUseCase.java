package com.like.system.systemcode.application.port.in.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeQueryUseCase {

	List<BizCodeTypeQueryResultDTO> select(String companyCode);
}
