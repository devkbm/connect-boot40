package com.like.system.user.application.port.in.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SystemUserDeleteUseCase {
	void delete(String userId);
}
