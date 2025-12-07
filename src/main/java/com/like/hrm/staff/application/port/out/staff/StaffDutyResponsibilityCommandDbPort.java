package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDutyId;

@SecondaryPort
public interface StaffDutyResponsibilityCommandDbPort {

	Optional<StaffDuty> select(StaffDutyId id);	

	void save(StaffDuty entity);
	
	void delete(StaffDutyId id);
}
