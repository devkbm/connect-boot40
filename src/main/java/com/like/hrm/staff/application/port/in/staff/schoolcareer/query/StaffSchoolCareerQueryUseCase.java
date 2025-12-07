package com.like.hrm.staff.application.port.in.staff.schoolcareer.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffSchoolCareerQueryUseCase {
	List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo);
}
