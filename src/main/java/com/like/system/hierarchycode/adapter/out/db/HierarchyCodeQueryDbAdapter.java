package com.like.system.hierarchycode.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.hierarchycode.adapter.out.db.querydsl.HierarchyCodeQuerydsl;
import com.like.system.hierarchycode.application.port.in.query.HierarchyCodeQueryResultDTO;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeQueryDbPort;

@Repository
public class HierarchyCodeQueryDbAdapter implements HierarchyCodeQueryDbPort {
	
	HierarchyCodeQuerydsl repository;
	
	HierarchyCodeQueryDbAdapter(HierarchyCodeQuerydsl repository) {
		this.repository = repository;
	}

	@Override
	public List<HierarchyCodeQueryResultDTO> query() {
		return this.repository.query();
	}
	
	
}
