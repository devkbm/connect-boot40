package com.like.system.menu_role.application.service.role;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.role.delete.RoleDeleteUseCase;
import com.like.system.menu_role.application.port.out.role.RoleCommandDbPort;

@Application
@Service
public class RoleDeleteService implements RoleDeleteUseCase {

	RoleCommandDbPort port;

	public RoleDeleteService(RoleCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String roleCode) {
		this.port.delete(companyCode, roleCode);		
	}
	
}
