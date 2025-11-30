package com.like.system.menu_role.application.port.in.menu.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MenuQueryUseCase {
	List<MenuQueryResultDTO> selectList(MenuQueryDTO dto);
}
