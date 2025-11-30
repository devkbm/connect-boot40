package com.like.system.menu_role.application.port.in.role.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface RoleQueryUseCase {
	List<RoleQueryResultDTO> getList(RoleQueryDTO condition);
}
