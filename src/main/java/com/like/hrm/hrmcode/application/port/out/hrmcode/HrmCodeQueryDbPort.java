package com.like.hrm.hrmcode.application.port.out.hrmcode;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.hrmcode.application.dto.hrmcode.HrmCodeQueryDTO;
import com.like.hrm.hrmcode.domain.HrmCode;

@SecondaryPort
public interface HrmCodeQueryDbPort {
	List<HrmCode> select(HrmCodeQueryDTO dto);
	
	List<HrmCode> selectList(List<String> typeIds);
}
