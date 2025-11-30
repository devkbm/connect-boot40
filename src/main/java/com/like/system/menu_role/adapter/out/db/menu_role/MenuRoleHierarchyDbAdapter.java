package com.like.system.menu_role.adapter.out.db.menu_role;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu_role.querydsl.MenuRoleHierarchyQuerydsl;
import com.like.system.menu_role.application.port.out.menu_role.MenuRoleHierarchySelectDbPort;
import com.like.system.menu_role.domain.menu_role.MenuRoleHierarchy;

@SecondaryAdapter
@Repository
public class MenuRoleHierarchyDbAdapter implements MenuRoleHierarchySelectDbPort {

	MenuRoleHierarchyQuerydsl repository;
	
	MenuRoleHierarchyDbAdapter(MenuRoleHierarchyQuerydsl repository) {
		this.repository = repository;		
	}
	
	@Override
	public List<MenuRoleHierarchy> select(String companyCode, String menuGroupCode, String roleCode) {
								
		return repository.select(companyCode, menuGroupCode, roleCode);
	}

}
