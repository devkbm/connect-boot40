package com.like.system.company.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class CompanyInfoId implements Serializable {
	
	private static final long serialVersionUID = 7980451248122646591L;
	
	@Column(name="ORG_CD")
	String companyCode;	
	
	protected CompanyInfoId() {}
	
	public CompanyInfoId(String companyCode) {
		this.companyCode = companyCode;
	}
	
	public String companyCode() {
		return companyCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyInfoId other = (CompanyInfoId) obj;
		return Objects.equals(companyCode, other.companyCode);
	}		
	
}
