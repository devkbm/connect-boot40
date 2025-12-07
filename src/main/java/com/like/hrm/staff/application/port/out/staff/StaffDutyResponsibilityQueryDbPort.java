package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query.StaffDutyResponsibilityQueryResultDTO;

@SecondaryPort
public interface StaffDutyResponsibilityQueryDbPort {
	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
