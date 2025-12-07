package com.like.hrm.hrmcode.application.port.out.hrmcodetype;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.hrm.hrmcode.domain.HrmCodeType;

@SecondaryPort
public interface HrmCodeTypeCommandDbPort {

	Optional<HrmCodeType> select(String id);
	
	void save(HrmCodeType entity);
	
	void delete(String id);
}
