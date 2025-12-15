package com.like.hrm.staff.domain.staff;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import com.like.hrm.staff.domain.staff.appointment.AppointmentInformation;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 김병민
 *
 */
// 용어 참고 https://terms.naver.com/list.naver?cid=51072&categoryId=51072
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class CurrentAppointmentInformation {
			
	@Column(name="BLNG_DEPT_CODE", comment="소속부서코드")
	String blngDeptCode;
			
	@Column(name="WORK_DEPT_CODE", comment="근무부서코드")
	String workDeptCode;
			
	@Column(name="JOB_GROUP_CODE", comment="직군코드")
	String jobGroupCode;
			
	@Column(name="JOB_POSITION_CODE", comment="직위코드")
	String jobPositionCode;
			
	@Column(name="OCCUPATION_CODE", comment="직종코드")
	String occupationCode;
			
	@Column(name="JOB_GRADE_CODE", comment="직급코드")
	String jobGradeCode;
			
	@Column(name="PAY_STEP_CODE", comment="호봉코드")
	String payStepCode;
			
	@Column(name="JOB_CODE", comment="직무코드")
	String jobCode;
		
	public CurrentAppointmentInformation(AppointmentInformation info) {
		this.apply(info);
	}
	
	void apply(AppointmentInformation info) {
		this.blngDeptCode = info.getBlngDeptCode();
		this.workDeptCode = info.getWorkDeptCode();
		this.jobGroupCode = info.getJobGroupCode();
		this.jobPositionCode = info.getJobPositionCode();
		this.occupationCode = info.getOccupationCode();
		this.jobGradeCode = info.getJobGradeCode();
		this.payStepCode = info.getPayStepCode();
		this.jobCode = info.getJobCode();
	}
}
