package com.like.system.user.application.port.in.password;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SystemUserPasswordInitUseCase {

	void initPassword(String companyCode, String userId);
}
