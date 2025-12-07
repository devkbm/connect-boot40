package com.like.hrm.staff.application.port.in.staff.license.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffLicenseQueryUseCase {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
