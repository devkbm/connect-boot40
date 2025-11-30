package com.like.system.menu_role.application.port.in.menu.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuGroupSaveUseCase {
	boolean exist(String companyCode, String menuGroupCode);
	
	void save(MenuGroupSaveDTO dto);
}
