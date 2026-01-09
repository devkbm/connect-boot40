package com.like.system.bizcode.application.port.in.type.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeDeleteUseCase {
	void delete(String companyCode, String typeId);
}
