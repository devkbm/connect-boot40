package com.like.hrm.staff.domain.staff.period;

import java.io.Serializable;
import java.util.Objects;

import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StaffPeriodId implements Serializable {
	
	private static final long serialVersionUID = 1961973101886772836L;

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
	
	@Column(name="PERIOD_TYPE_CD")
	String periodType;
		
	@Column(name="SEQ", comment="등록순번")
	Long seq;
	
	public StaffPeriodId() {} 
	
	public StaffPeriodId(
			Staff staff,
			String periodType,
			Long seq
			) {
		this.companyCode = staff.id().companyCode();
		this.staffNo = staff.id().staffNo();
		this.periodType = periodType;
		this.seq = seq;
	}
	
	public StaffPeriodId(
			String companyCode,
			String staffNo,
			String periodType,
			Long seq
			) {
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.periodType = periodType;
		this.seq = seq;
	}

	public String companyCode() {
		return companyCode;
	}

	public String staffNo() {
		return staffNo;
	}

	public String periodType() {
		return periodType;
	}

	public Long seq() {
		return seq;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyCode, periodType, seq, staffNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffPeriodId other = (StaffPeriodId) obj;
		return Objects.equals(companyCode, other.companyCode) && Objects.equals(periodType, other.periodType)
				&& Objects.equals(seq, other.seq) && Objects.equals(staffNo, other.staffNo);
	}
	
	
}
