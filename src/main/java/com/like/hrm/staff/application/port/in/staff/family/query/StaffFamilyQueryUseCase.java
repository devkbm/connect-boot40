package com.like.hrm.staff.application.port.in.staff.family.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffFamilyQueryUseCase {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
