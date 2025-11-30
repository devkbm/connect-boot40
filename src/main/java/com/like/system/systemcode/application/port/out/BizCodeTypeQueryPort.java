package com.like.system.systemcode.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.systemcode.application.port.in.query.BizCodeTypeQueryResultDTO;

@SecondaryPort
public interface BizCodeTypeQueryPort {
	List<BizCodeTypeQueryResultDTO> select(String companyCode);
}
