package com.like.hrm.hrmcode.application.port.out.hrmcode;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.hrmcode.domain.HrmCode;
import com.like.hrm.hrmcode.domain.HrmCodeId;

@SecondaryPort
public interface HrmCodeCommandDbPort {
	Optional<HrmCode> select(HrmCodeId id);
	
	void save(HrmCode entity);
	
	void delete(HrmCodeId id);
}
