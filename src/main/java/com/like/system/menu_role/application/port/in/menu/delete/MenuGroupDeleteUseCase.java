package com.like.system.menu_role.application.port.in.menu.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuGroupDeleteUseCase {
	void delete(String companyCode, String menuGroupCode);
}
