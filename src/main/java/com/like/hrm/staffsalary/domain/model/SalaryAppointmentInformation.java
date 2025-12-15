package com.like.hrm.staffsalary.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class SalaryAppointmentInformation {
	
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
		
	@Column(name="DUTY_RESPONSIBILITY_CODE", comment="직책코드")
	String dutyResponsibilityCode;
	
	public SalaryAppointmentInformation(
			String blngDeptCode,
			String workDeptCode,
			String jobGroupCode,
			String jobPositionCode,
			String occupationCode,
			String jobGradeCode,
			String payStepCode,
			String jobCode,
			String dutyResponsibilityCode
			) {
		this.blngDeptCode = blngDeptCode;
		this.workDeptCode = workDeptCode;
		this.jobGroupCode = jobGroupCode;
		this.jobPositionCode = jobPositionCode;
		this.occupationCode = occupationCode;
		this.jobGradeCode = jobGradeCode;
		this.payStepCode = payStepCode;
		this.jobCode = jobCode;
		this.dutyResponsibilityCode = dutyResponsibilityCode;
	}
		
}
