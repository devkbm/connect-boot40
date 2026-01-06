package com.like.system.hierarchycode.application.service;

import java.util.List;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.hierarchycode.application.port.in.query.HierarchyCodeQueryResultDTO;
import com.like.system.hierarchycode.application.port.in.query.HierarchyCodeQueryUseCase;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeQueryDbPort;

@Application
@Service
public class HierarchyCodeQueryService implements HierarchyCodeQueryUseCase {

	HierarchyCodeQueryDbPort dbPort;
	
	HierarchyCodeQueryService(HierarchyCodeQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<HierarchyCodeQueryResultDTO> query() {
		return this.dbPort.query();
	}
	
	
}
