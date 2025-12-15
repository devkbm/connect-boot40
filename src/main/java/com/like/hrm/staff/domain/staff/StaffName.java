package com.like.hrm.staff.domain.staff;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
public class StaffName {
		
	@Column(name="STAFF_NAME", comment="직원명")
	String name;	
			
	@Column(name="STAFF_NAME_ENG", comment="직원명(영문)")
	String nameEng;
			
	@Column(name="STAFF_NAME_CHI", comment="직원명(한문)")
	String nameChi;
	
	private StaffName(String name) {
		this.name = name;
	}
	
	public static StaffName of(String name) {
		return new StaffName(name);	
	}
	
	public static StaffName of(String name, String nameEng, String nameChi) {		 		
		return new StaffName(name, nameEng, nameChi);
	}	
	
} 
