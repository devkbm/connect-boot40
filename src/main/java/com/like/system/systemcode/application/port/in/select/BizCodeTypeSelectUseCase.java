package com.like.system.systemcode.application.port.in.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeSelectUseCase {
	
	BizCodeTypeSelectDTO select(String companyCode, String typeId);
}
