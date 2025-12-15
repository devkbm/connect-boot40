package com.like.hrm.staff.domain.staff.appointment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//용어 참고 https://terms.naver.com/list.naver?cid=51072&categoryId=51072
@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Embeddable
public class AppointmentInformation {
	
	@Column(name="BLNG_DEPT_CODE", comment="소속부서코드")
	private String blngDeptCode;
			
	@Column(name="WORK_DEPT_CODE", comment="근무부서코드")
	private String workDeptCode;
		
	@Column(name="JOB_GROUP_CODE", comment="직군코드")
	private String jobGroupCode;
			
	@Column(name="JOB_POSITION_CODE", comment="직위코드")
	private String jobPositionCode;
			
	@Column(name="OCCUPATION_CODE", comment="직종코드")
	private String occupationCode;
			
	@Column(name="JOB_GRADE_CODE", comment="직급코드")
	private String jobGradeCode;
			
	@Column(name="PAY_STEP_CODE", comment="호봉코드")
	private String payStepCode;
			
	@Column(name="JOB_CODE", comment="직무코드")
	private String jobCode;
			
	@Column(name="DUTY_RESPONSIBILITY_CODE", comment="직책코드")
	private String dutyResponsibilityCode;
	
}
