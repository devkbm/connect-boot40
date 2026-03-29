package com.like.system.dept.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DeptId implements Serializable {
	
	private static final long serialVersionUID = 5869853950528008537L;

	@Column(name="ORG_CD")
	private String companyCode;
	
	@Column(name = "DEPT_CD", nullable = false)
	private String deptCode;
	
	protected DeptId() {}
	
	public DeptId(String companyCode, String deptCode) {
		this.companyCode = companyCode;
		this.deptCode = deptCode;
	}

	public String companyCode() {
		return companyCode;
	}

	public String deptCode() {
		return deptCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, deptCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeptId other = (DeptId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(deptCode, other.deptCode);
	}
	
	
}
