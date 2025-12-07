package com.like.hrm.payitem.domain.payinfo;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class PayStaffAppointment {

	@Comment("소속부서코드")
	@Column(name="BLNG_DEPT_CODE")
	String blngDeptCode;
		
	@Comment("근무부서코드")
	@Column(name="WORK_DEPT_CODE")
	String workDeptCode;
		
	@Comment("직군코드")
	@Column(name="JOB_GROUP_CODE")
	String jobGroupCode;
		
	@Comment("직위코드")
	@Column(name="JOB_POSITION_CODE")
	String jobPositionCode;
		
	@Comment("직종코드")
	@Column(name="OCCUPATION_CODE")
	String occupationCode;
		
	@Comment("직급코드")
	@Column(name="JOB_GRADE_CODE")
	String jobGradeCode;
		
	@Comment("호봉코드")
	@Column(name="PAY_STEP_CODE")
	String payStepCode;
		
	@Comment("직무코드")
	@Column(name="JOB_CODE")
	String jobCode;
		
	@Comment("직책코드")
	@Column(name="DUTY_RESPONSIBILITY_CODE")
	String dutyResponsibilityCode;
	
}
