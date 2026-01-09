package com.like.system.bizcode.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.bizcode.application.port.in.type.query.BizCodeTypeQueryResultDTO;

@SecondaryPort
public interface BizCodeTypeQueryDbPort {
	List<BizCodeTypeQueryResultDTO> select(String companyCode);
}
