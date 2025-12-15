package com.like.hrm.payitem.domain.payinfo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class PayStaffAppointment {
	
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
	
}
