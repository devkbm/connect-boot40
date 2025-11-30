package com.like.system.menu_role.application.port.in.menu.hierarchy;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuHierarchySelectUseCase {

	List<MenuHierarchyNgZorro> select(String companyCode, String menuGroupCode);	
}
