package com.like.system.menu_role.application.port.in.role.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface RoleSelectUseCase {
	RoleSelectDTO select(String companyCode, String roleCode);
}
