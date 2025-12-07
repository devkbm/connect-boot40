package com.like.hrm.hrmcode.application.port.in.hrmcode;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSelectDTO;

@PrimaryPort
public interface HrmCodeSelectUseCase {
	HrmCodeSelectDTO select(String type, String code);
}
