package com.like.system.menu_role.application.port.in.menu.save;

import java.util.Optional;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuAppIcon;
import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.MenuType;

public class MenuSaveDTOMapper {

	public static MenuSaveDTO toDTO(Menu entity) {
		
		Optional<MenuAppIcon> menuAppIcon = Optional.ofNullable(entity.appIcon());
		
		return MenuSaveDTO.builder()
				   	   .createdDt(entity.getCreatedDt())
				   	   .createdBy(entity.getCreatedBy() == null ? null : entity.getCreatedBy().getLoggedUser())
				   	   .modifiedDt(entity.getModifiedDt())
				   	   .modifiedBy(entity.getModifiedBy() == null ? null : entity.getModifiedBy().getLoggedUser())					   	   
				   	   .companyCode(entity.menuGroup().id().companyCode())
				   	   .menuGroupCode(entity.menuGroup().id().menuGroupCode())					   	   					   	   
				   	   .menuCode(entity.id().menuCode())
				   	   .menuName(entity.name())
				   	   .menuType(entity.type().toString())
				   	   .appUrl(entity.appUrl())
				   	   .appIconType(menuAppIcon.map(MenuAppIcon::getAppIconType).orElse(""))
				   	   .appIcon(menuAppIcon.map(MenuAppIcon::getAppIcon).orElse(""))
				   	   .sequence(entity.sequence())
				   	   .level(entity.level())
				   	   .parentMenuCode(entity.parentMenuCode())					   	   
				   	   .build();
	}
	
	public static Menu toEntity(MenuSaveDTO dto, MenuGroup menuGroup, Menu parentMenu) {
		Menu entity = Menu.builder()
						  .menuGroup(menuGroup)
						  .parent(parentMenu)
						  .companyCode(dto.companyCode())
						  .menuCode(dto.menuCode())
						  .menuName(dto.menuName())
						  .menuType(MenuType.valueOf(dto.menuType()))
						  .sequence(dto.sequence())
						  .level(dto.level())					   
						  .appUrl(dto.appUrl())
						  .appIcon(new MenuAppIcon(dto.appIconType(), dto.appIcon()))
						  .build();
		
		entity.createdAppUrl(dto.clientAppUrl());
		
		return entity;
	}

}
