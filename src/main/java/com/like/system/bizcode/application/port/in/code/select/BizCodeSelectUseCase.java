package com.like.system.bizcode.application.port.in.code.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeSelectUseCase {
	BizCodeSelectDTO select(String companyCode, String typeId, String code);	
}
