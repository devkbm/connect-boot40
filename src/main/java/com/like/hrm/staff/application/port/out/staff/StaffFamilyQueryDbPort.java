package com.like.hrm.staff.application.port.out.staff;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.staff.application.port.in.staff.family.query.StaffFamilyQueryResultDTO;

@SecondaryPort
public interface StaffFamilyQueryDbPort {
	List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo);
}
