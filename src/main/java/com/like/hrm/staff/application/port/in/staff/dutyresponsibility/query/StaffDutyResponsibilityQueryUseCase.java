package com.like.hrm.staff.application.port.in.staff.dutyresponsibility.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffDutyResponsibilityQueryUseCase {

	List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo);
}
