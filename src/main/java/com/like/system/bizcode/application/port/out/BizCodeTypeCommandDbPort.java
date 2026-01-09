package com.like.system.bizcode.application.port.out;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.bizcode.domain.BizCodeType;

@SecondaryPort
public interface BizCodeTypeCommandDbPort {

	Optional<BizCodeType> select(String companyCode, String typeId);
	
	void Save(BizCodeType entity);
	
	void delete(String companyCode, String typeId);	
}
