package com.like.system.menu_role.application.port.in.menu_role.select;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuRoleHierarchySelectUseCase {
	List<?> select(String companyCode, String menuGroupCode, String roleCode);
}
