package com.like.hrm.staff.adapter.out.db.staff.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryDTO;
import com.like.hrm.staff.application.port.in.staff.appointment.query.StaffAppointmentQueryResultDTO;

@Mapper
public interface StaffAppointmentQueryOracle {

	@Select("""
	<script>

	select
        ar1_0.org_cd													companyCode,
        ar1_0.staff_no													staffNo,
        ar1_0.staff_name												staffName,
        ar1_0.seq														seq,
        ar1_0.appointment_type_code										appointmentTypeCode,
        hc1_0.code_nm													appointmentTypeName,
        ar1_0.appointment_dt											appointmentDate,
        ar1_0.appointment_end_dt										appointmentEndDate,
        ar1_0.record_name												recordName,
        ar1_0.cmt														comment,
        ar1_0.complete_yn												isCompleted,
        ar1_0.blng_dept_code											blngDeptCode,
        d1_0.dept_nm_kor												blngDeptName,
        ar1_0.work_dept_code											workDeptCode,
        d2_0.dept_nm_kor												workDeptName,
        ar1_0.job_group_code											jobGroupCode,
        hc2_0.code_nm													jobGroupName,
        ar1_0.job_position_code											jobPositionCode,
        hc3_0.code_nm													jobPositionName,
        ar1_0.occupation_code											occupationCode,
        hc4_0.code_nm													occupationName,
        ar1_0.job_grade_code											jobGradeCode,
        hc5_0.code_nm													jobGradeName,
        ar1_0.pay_step_code												payStepCode,
        hc6_0.code_nm													payStepName,
        ar1_0.job_code													jobCode,
        hc7_0.code_nm													jobName,
        ar1_0.duty_responsibility_code									dutyResponsibilityCode,
        FN_GET_HRMCODE_NAMES('HR0007',ar1_0.duty_responsibility_code)	dutyResponsibilityName	 
    from
        hrmstaff s1_0 
    join
        hrmstaffappointmentrecord ar1_0 
            on (s1_0.org_cd, s1_0.staff_no)=(ar1_0.org_cd, ar1_0.staff_no) 
            
    left join
        comdept d1_0 
            on d1_0.org_cd=s1_0.org_cd 
            and d1_0.dept_cd=ar1_0.blng_dept_code 
    left join
        comdept d2_0 
            on d2_0.org_cd=s1_0.org_cd 
            and d2_0.dept_cd=ar1_0.work_dept_code 
    left join
        hrmcode hc1_0 
            on hc1_0.type_id='HR0000' 
            and ar1_0.appointment_type_code=hc1_0.code 
    left join
        hrmcode hc2_0 
            on hc2_0.type_id='HR0001' 
            and ar1_0.job_group_code=hc2_0.code 
    left join
        hrmcode hc3_0 
            on hc3_0.type_id='HR0002' 
            and ar1_0.job_position_code=hc3_0.code 
    left join
        hrmcode hc4_0 
            on hc4_0.type_id='HR0003' 
            and ar1_0.occupation_code=hc4_0.code 
    left join
        hrmcode hc5_0 
            on hc5_0.type_id='HR0004' 
            and ar1_0.job_grade_code=hc5_0.code 
    left join
        hrmcode hc6_0 
            on hc6_0.type_id='HR0005' 
            and ar1_0.pay_step_code=hc6_0.code 
    left join
        hrmcode hc7_0 
            on hc7_0.type_id='HR0006' 
            and ar1_0.job_code=hc7_0.code 
    where
        (
            s1_0.STAFF_YN = true
        ) 
        and s1_0.org_cd  = #{companyCode}
    <if test="staff_no != null"><![CDATA[
	   AND s1_0.staff_no= #{staffNo}
	]]></if>         	       
    <if test="appointmentTypeCode != null"><![CDATA[
	   AND s1_0.appointment_type_code = #{appointmentTypeCode}
	]]></if>
	<if test="from != null"><![CDATA[
	   AND s1_0.appointment_dt between #{from} and #{to} 
	]]></if> 	
	</script>
	""")		
	List<StaffAppointmentQueryResultDTO> query(StaffAppointmentQueryDTO dto);
}
