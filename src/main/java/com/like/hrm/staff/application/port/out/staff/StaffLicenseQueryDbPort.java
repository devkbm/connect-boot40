package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.application.port.in.staff.license.query.StaffLicenseQueryResultDTO;

@SecondaryPort
public interface StaffLicenseQueryDbPort {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
