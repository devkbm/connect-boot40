package com.like.system.menu_role.application.port.out.menu;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.menu_role.application.port.in.menu.query.MenuGroupQueryDTO;
import com.like.system.menu_role.domain.menu.MenuGroup;

@SecondaryPort
public interface MenuGroupQueryDbPort {
	List<MenuGroup> selectList(MenuGroupQueryDTO dto);
}
