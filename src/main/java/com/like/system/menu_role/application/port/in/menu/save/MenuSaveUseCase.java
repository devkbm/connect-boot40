package com.like.system.menu_role.application.port.in.menu.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuSaveUseCase {
	boolean exist(String companyCode, String menuGroupCode, String menuCode);
	
	void save(MenuSaveDTO dto);
}
