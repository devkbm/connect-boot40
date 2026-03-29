package com.like.system.menu_role.domain.role;

import java.util.Objects;

public class RoleId {

	String companyCode;
	
	String roleCode;
	
	public RoleId(String companyCode, String roleCode) {
		this.companyCode = companyCode;
		this.roleCode = roleCode;
	}

	public String companyCode() {
		return companyCode;
	}

	public String roleCode() {
		return roleCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, roleCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleId other = (RoleId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(roleCode, other.roleCode);
	}
		
	
}
