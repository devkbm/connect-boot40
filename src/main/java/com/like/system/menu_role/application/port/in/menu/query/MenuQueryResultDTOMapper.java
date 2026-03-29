package com.like.system.menu_role.application.port.in.menu.query;

import java.util.Optional;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuAppIcon;

public class MenuQueryResultDTOMapper {

	public static MenuQueryResultDTO toDTO(Menu entity) {
		
		Optional<MenuAppIcon> menuAppIcon = Optional.ofNullable(entity.appIcon());
		
		return MenuQueryResultDTO.builder()
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
	
}
