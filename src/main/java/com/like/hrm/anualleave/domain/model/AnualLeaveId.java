package com.like.hrm.anualleave.domain.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import com.like.hrm.staff.domain.staff.Staff;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of = {"companyCode","staffNo","yyyy"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class AnualLeaveId implements Serializable {
	
	private static final long serialVersionUID = 7192154823642621593L;

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO", comment="직원번호")
	String staffNo;
		
	@Column(name="YYYY", comment="귀속년도")
	Integer yyyy;			
	
	public AnualLeaveId(Staff staff, Integer yyyy) {
		this.companyCode = staff.getId().companyCode();
		this.staffNo = staff.getId().staffNo();
		this.yyyy = yyyy;
	}
}
