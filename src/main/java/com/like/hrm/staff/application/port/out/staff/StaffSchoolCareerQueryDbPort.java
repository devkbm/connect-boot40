package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.application.port.in.staff.schoolcareer.query.StaffSchoolCareerQueryResultDTO;

@SecondaryPort
public interface StaffSchoolCareerQueryDbPort {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
