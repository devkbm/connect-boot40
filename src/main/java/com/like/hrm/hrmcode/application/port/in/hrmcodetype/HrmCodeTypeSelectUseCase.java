package com.like.hrm.hrmcode.application.port.in.hrmcodetype;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.hrm.hrmcode.application.dto.hrmcodetype.HrmCodeTypeSaveDTO;

@PrimaryPort
public interface HrmCodeTypeSelectUseCase {

	HrmCodeTypeSaveDTO select(String id);
}
