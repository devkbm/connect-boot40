package com.like.hrm.staff.domain.staff.schoolcareer;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.like.common.vo.LocalDatePeriod;
import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.hrm.staff.domain.staff.Staff;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <p>부서 이력 관리 클래스</p>
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
@Table(name = "HRMSTAFFSCHOOLCAREER")
@EntityListeners(AuditingEntityListener.class)
public class StaffSchoolCareer extends AbstractAuditEntity implements Serializable {
	
	private static final long serialVersionUID = 5879415854289672377L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "ORG_CD", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name = "STAFF_NO", nullable=false, insertable=false, updatable=false)
	})
	private Staff staff;

	@EmbeddedId
	StaffSchoolCareerId id;
				
	@Column(name="SCHOOL_CAREER_CODE", comment="학력유형")
	String schoolCareerType;
			
	@Column(name="SCHOOL_CODE", comment="학교코드")
	String schoolCode;
		
	@Embedded
	LocalDatePeriod period;
			
	@Column(name="MAJOR_NAME", comment="전공학과명")
	String majorName;
			
	@Column(name="PLURAL_MAJOR_NAME", comment="복수전공학과명")
	String pluralMajorName;
			
	@Column(name="LOCATION_NAME", comment="소재지")
	String location;
			
	@Column(name="LESSON_YEAR", comment="수업연한")
	Integer lessonYear;
			
	@Column(name="CMT", comment="비고")
	String comment;
		
	// 시작일, 종료일, 전공학과명, 복수전공학과명, 학교소재지, 수업연한, 입사학력여부, 수고권대학여부, 야간여부, 이공계여부, 이미지	
	
	@Builder
	public StaffSchoolCareer(
			Staff staff,
			String schoolCareerType,
			String schoolCode,
			LocalDate fromDate,
			LocalDate toDate,
			String majorName,
			String pluralMajorName,
			String location,
			Integer lessonYear,
			String comment
			) {
		this.staff = staff;
		this.id = new StaffSchoolCareerId(staff, staff.getSchoolCareerList().getNextSequence());		
		this.schoolCareerType = schoolCareerType;
		this.schoolCode = schoolCode;
		this.period = new LocalDatePeriod(fromDate, toDate);
		this.majorName = majorName;
		this.pluralMajorName = pluralMajorName;
		this.location = location;
		this.lessonYear = lessonYear;
		this.comment = comment;
	}
		
	@Builder(builderMethodName = "modifyBuilder", buildMethodName = "modify")
	public void modifyEntity(
			String schoolCareerType,
			String schoolCode,
			LocalDate fromDate,
			LocalDate toDate,
			String majorName,
			String pluralMajorName,
			String location,
			Integer lessonYear,
			String comment
			) {
		this.schoolCareerType = schoolCareerType;
		this.schoolCode = schoolCode;
		this.period = new LocalDatePeriod(fromDate, toDate);
		this.majorName = majorName;
		this.pluralMajorName = pluralMajorName;
		this.location = location;
		this.lessonYear = lessonYear;
		this.comment = comment;
	}
				
}
