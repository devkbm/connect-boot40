package com.like.hrm.staff.domain.staff.license;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.hrm.staff.domain.staff.Staff;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <p>자격 면허 관리</p>
 * 
 * Unique Index : EMP_ID, DEPT_TYPE, DEPT_CODE <br>
 * [상세] <br>
 * 1. <br>
 * 2. <br>
 * @author 김병민
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"staff"})
@EqualsAndHashCode(callSuper = false, of = {"id"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMSTAFFLICENSE")
@EntityListeners(AuditingEntityListener.class)
public class StaffLicense extends AbstractAuditEntity implements Serializable {
	
	private static final long serialVersionUID = 5879415854289672377L;
	
	// 취득일자, 자격면허, 자격면허인가번호, 발행기관, 필수면허번호여부, 이미지		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "ORG_CD", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name = "STAFF_NO", nullable=false, insertable=false, updatable=false)
	})
	Staff staff;
	
	@EmbeddedId
	StaffLicenseId id;
				
	@Column(name="LICENSE_TYPE", nullable = false, comment="자격면허유형")
	String licenseType;
			
	@Column(name="LICENSE_NO", nullable = false, comment="자격면허번호")
	String licenseNumber;
		
	// acquisition date	
	@Column(name="DATE_OF_ACQUISITION", nullable = true, comment="취득일자")
	LocalDate dateOfAcquisition;
			
	@Column(name="CERTIFICATION_AUTHORITY", nullable = true, comment="인증기관")
	String certificationAuthority;		
			
	@Column(name="CMT", nullable = true, comment="비고")
	String comment;	
	
	@Builder
	public StaffLicense(
			Staff staff,
			String licenseType,
			String licenseNumber,
			LocalDate dateOfAcquisition,
			String certificationAuthority,
			String comment
			) {
		this.staff = staff;
		this.id = new StaffLicenseId(staff, staff.getLicenseList().getNextSequence());
		this.licenseType = licenseType;
		this.licenseNumber = licenseNumber;
		this.dateOfAcquisition = dateOfAcquisition;
		this.certificationAuthority = certificationAuthority;
		this.comment = comment;
	}
	
	@Builder(builderMethodName = "modifyBuilder", buildMethodName = "modify")
	public void modifyEntity(
			String licenseType,
			String licenseNumber,
			LocalDate dateOfAcquisition,
			String certificationAuthority,
			String comment
			) {
		this.licenseType = licenseType;
		this.licenseNumber = licenseNumber;
		this.dateOfAcquisition = dateOfAcquisition;
		this.certificationAuthority = certificationAuthority;
		this.comment = comment;		
	}
				
}
