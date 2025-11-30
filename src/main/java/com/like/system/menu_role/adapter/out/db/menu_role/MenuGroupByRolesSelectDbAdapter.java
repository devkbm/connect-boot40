package com.like.system.menu_role.adapter.out.db.menu_role;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.system.menu_role.adapter.out.db.menu_role.querydsl.MenuGroupByRolesSelectQuerydsl;
import com.like.system.menu_role.application.port.out.menu_role.MenuGroupByRolesSelectDbPort;
import com.like.system.menu_role.domain.menu.MenuGroup;

@SecondaryAdapter
@Repository
public class MenuGroupByRolesSelectDbAdapter implements MenuGroupByRolesSelectDbPort {

	MenuGroupByRolesSelectQuerydsl repository; 
	
	MenuGroupByRolesSelectDbAdapter(MenuGroupByRolesSelectQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<MenuGroup> select(String companyCode, List<String> roleCodes) {		
		return this.repository.select(companyCode, roleCodes);				               
	}

}
