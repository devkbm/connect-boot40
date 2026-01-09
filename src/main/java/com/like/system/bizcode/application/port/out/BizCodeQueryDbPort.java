package com.like.system.bizcode.application.port.out;

import java.util.List;

import com.like.system.bizcode.application.port.in.code.query.BizCodeQueryResultDTO;

public interface BizCodeQueryDbPort {

	List<BizCodeQueryResultDTO> query(String companyCode, String typeId);
}
