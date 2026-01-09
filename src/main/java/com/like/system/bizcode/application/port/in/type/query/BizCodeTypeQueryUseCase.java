package com.like.system.bizcode.application.port.in.type.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeQueryUseCase {

	List<BizCodeTypeQueryResultDTO> select(String companyCode);
}
