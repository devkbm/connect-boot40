package com.like.hrm.staff.domain.staff.contact;

import java.util.Objects;

import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContactInfoId {

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
			
	@Column(name="CONTACT_TYPE", comment="유형")
	String type;	
	
	public ContactInfoId(Staff staff, String type) {
		this.companyCode = staff.id().companyCode();
		this.staffNo = staff.id().staffNo();
		this.type = type;
	}
	
	public ContactInfoId() {}

	public String companyCode() {
		return companyCode;
	}

	public String staffNo() {
		return staffNo;
	}

	public String type() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, staffNo, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactInfoId other = (ContactInfoId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(staffNo, other.staffNo)
				&& Objects.equals(type, other.type);
	}
	
	
	
	
}
