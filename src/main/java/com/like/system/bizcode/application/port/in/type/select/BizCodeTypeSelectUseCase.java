package com.like.system.bizcode.application.port.in.type.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeSelectUseCase {
	
	BizCodeTypeSelectDTO select(String companyCode, String typeId);
}
