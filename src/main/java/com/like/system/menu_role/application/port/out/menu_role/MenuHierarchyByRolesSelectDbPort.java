package com.like.system.menu_role.application.port.out.menu_role;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.menu_role.domain.menu.MenuHierarchy;

@SecondaryPort
public interface MenuHierarchyByRolesSelectDbPort {

	List<MenuHierarchy> select(String companyCode, String menuGroupCode, List<String> roleCodes);
}
