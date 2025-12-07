package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.domain.staff.license.StaffLicense;
import com.like.hrm.staff.domain.staff.license.StaffLicenseId;

@SecondaryPort
public interface StaffLicenseCommandDbPort {

	Optional<StaffLicense> select(StaffLicenseId id);	

	void save(StaffLicense entity);
	
	void delete(StaffLicenseId id);
}
