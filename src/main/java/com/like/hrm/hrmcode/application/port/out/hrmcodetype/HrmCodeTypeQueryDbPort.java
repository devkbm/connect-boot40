package com.like.hrm.hrmcode.application.port.out.hrmcodetype;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.hrmcode.application.dto.hrmcodetype.HrmCodeTypeQueryDTO;
import com.like.hrm.hrmcode.domain.HrmCodeType;

@SecondaryPort
public interface HrmCodeTypeQueryDbPort {
	List<HrmCodeType> select(HrmCodeTypeQueryDTO dto);
}
