package com.like.system.menu_role.application.port.in.menu_role.save;

import java.util.List;

public interface MenuRoleMappingSaveUseCase {

	void save(List<MenuRoleMappingSaveDTO> entityList);
}
