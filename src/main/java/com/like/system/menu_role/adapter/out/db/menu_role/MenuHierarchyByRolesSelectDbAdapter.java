package com.like.system.menu_role.adapter.out.db.menu_role;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu_role.querydsl.MenuHierarchyByRolesSelectQuerydsl;
import com.like.system.menu_role.application.port.out.menu_role.MenuHierarchyByRolesSelectDbPort;
import com.like.system.menu_role.domain.menu.MenuHierarchy;

@Repository
public class MenuHierarchyByRolesSelectDbAdapter implements MenuHierarchyByRolesSelectDbPort {

	MenuHierarchyByRolesSelectQuerydsl repository;
	
	MenuHierarchyByRolesSelectDbAdapter(MenuHierarchyByRolesSelectQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<MenuHierarchy> select(String companyCode, String menuGroupCode, List<String> roleCodes) {		
		return repository.select(companyCode, menuGroupCode, roleCodes);	
	}

}
