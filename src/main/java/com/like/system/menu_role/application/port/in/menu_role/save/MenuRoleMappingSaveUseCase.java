package com.like.system.menu_role.application.port.in.menu_role.save;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuRoleMappingSaveUseCase {

	void save(List<MenuRoleMappingSaveDTO> entityList);
}
