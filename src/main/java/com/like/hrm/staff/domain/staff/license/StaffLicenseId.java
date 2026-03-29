package com.like.hrm.staff.domain.staff.license;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import com.like.hrm.staff.domain.staff.Staff;

@Embeddable
public class StaffLicenseId implements Serializable {
	
	private static final long serialVersionUID = -2126754308967909563L;

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
			
	@Column(name="SEQ", comment="등록순번")
	Long seq;
	
	public StaffLicenseId() {} 
	
	public StaffLicenseId(Staff staff, Long seq) {
		this.companyCode = staff.id().companyCode();
		this.staffNo = staff.id().staffNo();
		this.seq = seq;
	}	
	
	public StaffLicenseId(String companyCode, String staffNo, Long seq) {
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.seq = seq;
	}

	public String companyCode() {
		return companyCode;
	}

	public String staffNo() {
		return staffNo;
	}

	public Long seq() {
		return seq;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, seq, staffNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffLicenseId other = (StaffLicenseId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(seq, other.seq)
				&& Objects.equals(staffNo, other.staffNo);
	}
	
	
	
	
}
