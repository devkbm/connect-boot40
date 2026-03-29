package com.like.system.user.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SystemUserCompanyRoleId implements Serializable {
		
	private static final long serialVersionUID = 8341227268289327529L;
	
	SystemUserId userId;
		
	@Column(name="ORG_CD")
	private String companyCode;
	
	@Column(name="ROLE_CD")
	String roleCode;
	
	public SystemUserCompanyRoleId(String userId, String companyCode, String roleCode) {		
		this.userId = new SystemUserId(userId);
		this.companyCode = companyCode;
		this.roleCode = roleCode;
	}
	
	protected SystemUserCompanyRoleId() {}

	public SystemUserId userId() {
		return userId;
	}

	public String companyCode() {
		return companyCode;
	}

	public String roleCode() {
		return roleCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, roleCode, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemUserCompanyRoleId other = (SystemUserCompanyRoleId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(roleCode, other.roleCode)
				&& Objects.equals(userId, other.userId);
	}
	
	
	
	
}
