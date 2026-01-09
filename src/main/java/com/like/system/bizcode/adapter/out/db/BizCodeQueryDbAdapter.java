package com.like.system.bizcode.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.bizcode.adapter.out.db.querydsl.BizCodeQuerydsl;
import com.like.system.bizcode.application.port.in.code.query.BizCodeQueryResultDTO;
import com.like.system.bizcode.application.port.out.BizCodeQueryDbPort;

@Repository
public class BizCodeQueryDbAdapter implements BizCodeQueryDbPort {

	BizCodeQuerydsl repository;
	
	BizCodeQueryDbAdapter(BizCodeQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<BizCodeQueryResultDTO> query(String companyCode, String typeId) {
		return this.repository.query(companyCode, typeId);
	}

}
