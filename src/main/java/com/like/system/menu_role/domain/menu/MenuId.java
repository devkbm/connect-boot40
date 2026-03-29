package com.like.system.menu_role.domain.menu;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MenuId implements Serializable {

	private static final long serialVersionUID = 1466162239881162136L;

	MenuGroupId menuGroupId;
		
	@Column(name="MENU_CD", comment="메뉴코드")
	String menuCode;
	
	protected MenuId() {}

	public MenuId(MenuGroupId menuGroupId, String menuCode) {	
		this.menuGroupId = menuGroupId;
		this.menuCode = menuCode;
	}
	
	public MenuId(String companyCode, String menuGroupCode, String menuCode) {	
		this.menuGroupId = new MenuGroupId(companyCode, menuGroupCode);
		this.menuCode = menuCode;
	}

	public MenuGroupId menuGroupId() {
		return menuGroupId;
	}

	public String menuCode() {
		return menuCode;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(menuCode, menuGroupId.companyCode, menuGroupId.menuGroupCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuId other = (MenuId) obj;
		return Objects.equals(menuCode, other.menuCode) 
			&& Objects.equals(menuGroupId.companyCode, other.menuGroupId.companyCode)
			&& Objects.equals(menuGroupId.menuGroupCode, other.menuGroupId.menuGroupCode);
	}	
	
}
