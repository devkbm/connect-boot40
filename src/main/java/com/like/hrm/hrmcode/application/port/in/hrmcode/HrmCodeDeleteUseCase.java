package com.like.hrm.hrmcode.application.port.in.hrmcode;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HrmCodeDeleteUseCase {
	void delete(String type, String code);
}
