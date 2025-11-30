package com.like.system.systemcode.application.port.in.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeDeleteUseCase {
	void delete(String companyCode, String typeId, String code);
}
