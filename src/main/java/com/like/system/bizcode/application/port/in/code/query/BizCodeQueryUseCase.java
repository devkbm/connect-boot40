package com.like.system.bizcode.application.port.in.code.query;

import java.util.List;

public interface BizCodeQueryUseCase {

	List<BizCodeQueryResultDTO> query(String companyCode, String typeId);
	
}
