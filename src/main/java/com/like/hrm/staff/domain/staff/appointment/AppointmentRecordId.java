package com.like.hrm.staff.domain.staff.appointment;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import com.like.hrm.staff.domain.staff.Staff;

@Embeddable
public class AppointmentRecordId implements Serializable {
	
	private static final long serialVersionUID = -9052607243196727987L;

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
		
	@Column(name="SEQ", comment="등록순번")
	Long seq;
	
	public AppointmentRecordId(Staff staff, Long seq) {
		this.companyCode = staff.id().companyCode();
		this.staffNo = staff.id().staffNo();
		this.seq = seq;
	}
	
	public AppointmentRecordId(String companyCode, String staffNo, Long seq) {
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.seq = seq;
	}
	
	public AppointmentRecordId() {}

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
		AppointmentRecordId other = (AppointmentRecordId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(seq, other.seq)
				&& Objects.equals(staffNo, other.staffNo);
	} 
	
	
	
}
