package com.like.hrm.staff.application.port.in.partner.query;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PartnerCompanyStaffQueryResultDTO {			
	String companyCode;
	String staffNo;
	String name;
	String nameEng;
	String nameChi;
	String residentRegistrationNumber;
	String gender;
	LocalDate birthday;
	String imagePath;	
	String partnerCompanyCode;		
	String workStateCode;
	LocalDate joinDate;
	LocalDate retireDate;
	String blngDeptCode;
	String workDeptCode;
}