package com.like.system.user.application.port.in.profile;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SystemUserProfileSelectUseCase {

	SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto);
}
