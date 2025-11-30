package com.like.system.menu_role.application.port.out.menu_role;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.menu_role.domain.menu.MenuGroup;

@SecondaryPort
public interface MenuGroupByRolesSelectDbPort {
	List<MenuGroup> select(String companyCode, List<String> roleCodes);
}
