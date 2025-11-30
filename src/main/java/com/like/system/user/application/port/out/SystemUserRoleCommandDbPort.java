package com.like.system.user.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.user.domain.SystemUserCompanyRole;

@SecondaryPort
public interface SystemUserRoleCommandDbPort {
	List<RoleJpaEntity> select(String companyCode, List<String> roles);
	
	void save(List<SystemUserCompanyRole> roleList);
	
	void delete(List<SystemUserCompanyRole> roleList);
}
