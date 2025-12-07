package com.like.hrm.hrmcode.application.port.in.hrmcode;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeSaveDTO;

@PrimaryPort
public interface HrmCodeSaveUseCase {
	void save(HrmCodeSaveDTO dto);
}
