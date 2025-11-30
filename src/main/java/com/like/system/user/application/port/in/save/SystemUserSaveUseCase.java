package com.like.system.user.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SystemUserSaveUseCase {
	
	boolean exists(String userId); 
		
	void save(SystemUserSaveDTO dto);	
}
