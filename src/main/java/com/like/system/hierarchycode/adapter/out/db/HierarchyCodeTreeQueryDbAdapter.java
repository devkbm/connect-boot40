package com.like.system.hierarchycode.adapter.out.db;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.system.hierarchycode.adapter.out.db.querydsl.HieraryCodeTreeQuerydsl;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryResultDTO;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeTreeQueryDbPort;

@SecondaryAdapter
@Repository
public class HierarchyCodeTreeQueryDbAdapter implements HierarchyCodeTreeQueryDbPort {

	HieraryCodeTreeQuerydsl repository;
	
	HierarchyCodeTreeQueryDbAdapter(HieraryCodeTreeQuerydsl repository) {
		this.repository = repository;
	}
	
	@Override
	public List<HierarchyCodeTreeQueryResultDTO> getCodeHierarchyList(HierarchyCodeTreeQueryDTO dto) {
		return this.repository.getCodeHierarchyList(dto);
	}

}
