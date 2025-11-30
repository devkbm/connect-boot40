package com.like.system.systemcode.application.port.in.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeSelectUseCase {
	BizCodeSelectDTO select(String companyCode, String typeId, String code);	
}
