package com.like.system.user.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SystemUserCompanyId implements Serializable {
	
	private static final long serialVersionUID = 2360915143791502459L;

	SystemUserId userId;	
	
	@Column(name="ORG_CD")
	String companyCode;
	
	public SystemUserCompanyId(String companyCode, String userId) {		
		this.userId = new SystemUserId(userId);
		this.companyCode = companyCode;
	}
	
	protected SystemUserCompanyId() {}

	public SystemUserId userId() {
		return userId;
	}

	public String companyCode() {
		return companyCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemUserCompanyId other = (SystemUserCompanyId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(userId, other.userId);
	}	
	
}
