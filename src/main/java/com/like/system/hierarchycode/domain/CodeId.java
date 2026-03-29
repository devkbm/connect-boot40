package com.like.system.hierarchycode.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CodeId implements Serializable {
	
	private static final long serialVersionUID = 5066344742442647534L;

	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="CODE_ID")
	String codeId;
	
	protected CodeId() {}
	
	public CodeId(String companyCode, String codeId) {
		this.companyCode = companyCode;		
		this.codeId = codeId;		
	}
	
	public CodeId(String companyCode, Code parentCode, String code) {
		this.companyCode = companyCode;		
		
		if ( parentCode == null ) {
			this.codeId = code;			
		} else {
			this.codeId = parentCode.id().codeId() + code;
		}
	}

	public String companyCode() {
		return companyCode;
	}

	public String codeId() {
		return codeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeId, companyCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodeId other = (CodeId) obj;
		return Objects.equals(codeId, other.codeId) && Objects.equals(companyCode, other.companyCode);
	}	
	
}
