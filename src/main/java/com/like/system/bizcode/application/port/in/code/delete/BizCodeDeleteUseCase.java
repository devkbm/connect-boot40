package com.like.system.bizcode.application.port.in.code.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeDeleteUseCase {
	void delete(String companyCode, String typeId, String code);
}
