package com.like.hrm.hrmcode.application.port.in.hrmcodetype;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HrmCodeTypeDeleteUseCase {
	void delete(String id);
}
