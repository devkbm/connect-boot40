package com.like.system.systemcode.application.port.in.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeDeleteUseCase {
	void delete(String companyCode, String typeId);
}
