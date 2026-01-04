package com.like.system.hierarchycode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.hierarchycode.application.port.in.delete.HierarchyCodeDeleteUseCase;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeCommandDbPort;
import com.like.system.hierarchycode.domain.CodeId;

@Application
@Service
public class HierarchyCodeDeleteService implements HierarchyCodeDeleteUseCase {

	HierarchyCodeCommandDbPort dbPort;
	
	HierarchyCodeDeleteService(HierarchyCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(String companyCode, String codeId) { 
		dbPort.delete(new CodeId(companyCode, codeId));
	}

}
