package com.like.hrm.staff.application.port.in.staff;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffCreateUseCase {
	void create(StaffCreateDTO dto);
}
