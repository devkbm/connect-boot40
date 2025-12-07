package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareer;
import com.like.hrm.staff.domain.staff.schoolcareer.StaffSchoolCareerId;

@SecondaryPort
public interface StaffSchoolCareerCommandDbPort {

	Optional<StaffSchoolCareer> select(StaffSchoolCareerId id);	

	void save(StaffSchoolCareer entity);
	
	void delete(StaffSchoolCareerId id);
}
