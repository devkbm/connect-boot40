package com.like.system.user.application.port.in.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SystemUserSelectUseCase {
	SystemUserSelectDTO selectDTO(String userId, String companyCode);	
}
