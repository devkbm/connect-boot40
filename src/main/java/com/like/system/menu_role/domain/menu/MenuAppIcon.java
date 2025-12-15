package com.like.system.menu_role.domain.menu;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Embeddable
public class MenuAppIcon implements Serializable {
	
	private static final long serialVersionUID = -6474952912094147032L;
		
	@Column(name="APP_ICON_TYPE", comment="APP_ICON_TYPE")
	String appIconType;
		
	@Column(name="APP_ICON", comment="APP ICON")
	String appIcon;	
	
	public MenuAppIcon(String appIconType, String appIcon) {
		this.appIconType = appIconType;
		this.appIcon = appIcon;
	}
}
