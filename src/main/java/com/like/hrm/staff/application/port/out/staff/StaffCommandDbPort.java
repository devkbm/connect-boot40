package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.domain.staff.Staff;

@SecondaryPort
public interface StaffCommandDbPort {
	
	Optional<Staff> select(String companyCode, String staffNo);
	
	void save(Staff entity);
	
	void delete(String companyCode, String staffNo);

}
