package com.like.system.bizcode.application.port.out;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.bizcode.domain.BizCode;

@SecondaryPort
public interface BizCodeCommandDbPort {

	Optional<BizCode> select(String companyCode, String typeId, String code);
		
	void save(BizCode entity);
	
	void delete(String companyCode, String typeId, String code);
}
