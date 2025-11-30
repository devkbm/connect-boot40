package com.like.system.dept.adapter.out.db;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.system.dept.adapter.out.db.query.DeptHierarchyQuerydsl;
import com.like.system.dept.application.port.out.DeptHierarchySelectDbPort;
import com.like.system.dept.domain.DeptHierarchy;

@SecondaryAdapter
@Repository
public class DeptHierarchyDbAdpater implements DeptHierarchySelectDbPort {
	
	DeptHierarchyQuerydsl repository;
	
	DeptHierarchyDbAdpater(DeptHierarchyQuerydsl query) {
		this.repository = query;
	}
	
	@Override
	public List<DeptHierarchy> getAllNodes(String companyCode) {
		return this.repository.getAllNodes(companyCode);	
	}

}
