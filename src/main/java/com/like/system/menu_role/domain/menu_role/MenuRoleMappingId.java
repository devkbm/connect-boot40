package com.like.system.menu_role.domain.menu_role;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MenuRoleMappingId implements Serializable {
	
	private static final long serialVersionUID = -128283423937776316L;

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="MENU_GROUP_CD")
	String menuGroupCode;
	
	@Column(name="MENU_CD")
	String menuCode;
		
	@Column(name="ROLE_CD", comment="ROLE 코드")
	String roleCode;
	
	protected MenuRoleMappingId() {}
	
	public MenuRoleMappingId(String companyCode, String menuGroupCode, String menuCode, String roleCode) {			
		this.companyCode = companyCode;
		this.menuGroupCode = menuGroupCode;
		this.menuCode = menuCode;
		this.roleCode = roleCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, menuCode, menuGroupCode, roleCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuRoleMappingId other = (MenuRoleMappingId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(menuCode, other.menuCode)
				&& Objects.equals(menuGroupCode, other.menuGroupCode) && Objects.equals(roleCode, other.roleCode);
	}
	
	
	
}
