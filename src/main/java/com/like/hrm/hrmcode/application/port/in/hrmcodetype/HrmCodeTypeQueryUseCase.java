package com.like.hrm.hrmcode.application.port.in.hrmcodetype;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.hrm.hrmcode.application.dto.hrmcodetype.HrmCodeTypeQueryDTO;
import com.like.hrm.hrmcode.application.dto.hrmcodetype.HrmCodeTypeSaveDTO;

@PrimaryPort
public interface HrmCodeTypeQueryUseCase {
	List<HrmCodeTypeSaveDTO> select(HrmCodeTypeQueryDTO dto);
}
