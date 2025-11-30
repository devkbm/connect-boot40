package com.like.system.menu_role.application.port.in.role.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface RoleSaveUseCase {
	
	boolean exists(String companyCode, String roleCode);
	
	void save(RoleSaveDTO dto);
}
