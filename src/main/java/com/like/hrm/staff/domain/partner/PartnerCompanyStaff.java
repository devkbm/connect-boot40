package com.like.hrm.staff.domain.partner;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.hrm.staff.domain.AbstractStaff;
import com.like.hrm.staff.domain.staff.ResidentRegistrationNumber;
import com.like.hrm.staff.domain.staff.StaffId;
import com.like.hrm.staff.domain.staff.StaffName;
import com.like.hrm.staff.domain.staff.StaffNoCreateStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@SQLRestriction("STAFF_YN = false")
@Table(name = "HRMSTAFF")
@EntityListeners(AuditingEntityListener.class)
public class PartnerCompanyStaff extends AbstractStaff {

	@EmbeddedId
	StaffId id;
	
	@Embedded
	StaffName name;
				
	@Embedded
	ResidentRegistrationNumber residentRegistrationNumber;
	
	@Column(name="STAFF_YN")
	Boolean isStaff = false;
		
	@Column(name="GENDER", comment="성별")
	String gender;
					
	@Column(name="BIRTHDAY", comment="생일")
	LocalDate birthday;	
		
	@Column(name="IMG_PATH", comment="이미지경로")
	String imagePath;
				
	@Column(name="PARTNER_COMP_CODE", comment="소속부서코드")
	String partnerCompanyCode;
		
	@Column(name="WORK_STATE_CODE", comment="근무상태")
	String workStateCode;
		
	@Column(name="JOIN_COMP_DT", comment="입사일")
	LocalDate joinDate;
		
	@Column(name="RETIRE_COMP_DT", comment="퇴사일")
	LocalDate retireDate;
							
	@Column(name="BLNG_DEPT_CODE", comment="소속부서코드")
	String blngDeptCode;
			
	@Column(name="WORK_DEPT_CODE", comment="근무부서코드")
	String workDeptCode;
	
	public PartnerCompanyStaff(
			String companyCode, 
			StaffNoCreateStrategy strategy, 
			StaffName name, 
			String gender, 
			LocalDate birthday,
			String partnerCompanyCode,
			LocalDate joinDate,
			LocalDate retireDate,
			String blngDeptCode,
			String workDeptCode
			) {
		this.id 			= new StaffId(companyCode, strategy.create());
		this.name 			= name; 		
		this.gender 		= gender;
		this.birthday		= birthday;
		this.partnerCompanyCode = partnerCompanyCode;
		this.joinDate 		= joinDate;
		this.retireDate 	= retireDate;
		this.blngDeptCode	= blngDeptCode;
		this.workDeptCode	= workDeptCode;
	}
	
	public void modify(
			StaffName name, 
			String gender, 
			LocalDate birthday,
			String partnerCompanyCode,
			LocalDate joinDate,
			LocalDate retireDate,
			String blngDeptCode,
			String workDeptCode
			) {
		this.name 			= name; 		
		this.gender 		= gender;
		this.birthday		= birthday;
		this.partnerCompanyCode = partnerCompanyCode;
		this.joinDate 		= joinDate;
		this.retireDate 	= retireDate;
		this.blngDeptCode	= blngDeptCode;
		this.workDeptCode	= workDeptCode;
	}
}
