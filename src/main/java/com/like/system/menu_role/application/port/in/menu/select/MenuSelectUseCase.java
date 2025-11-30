package com.like.system.menu_role.application.port.in.menu.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuSelectUseCase {
	MenuSelectDTO select(String companyCode, String menuGroupCode, String menuCode);	
}
