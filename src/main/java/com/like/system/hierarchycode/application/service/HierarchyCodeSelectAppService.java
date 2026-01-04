package com.like.system.hierarchycode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.hierarchycode.application.port.in.select.HierarchyCodeSelectDTO;
import com.like.system.hierarchycode.application.port.in.select.HierarchyCodeSelectDTOMapper;
import com.like.system.hierarchycode.application.port.in.select.HierarchyCodeSelectUseCase;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeCommandDbPort;
import com.like.system.hierarchycode.domain.CodeId;

@Application
@Service
public class HierarchyCodeSelectAppService implements HierarchyCodeSelectUseCase {

	HierarchyCodeCommandDbPort dbPort;
	
	HierarchyCodeSelectAppService(HierarchyCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public HierarchyCodeSelectDTO selectCode(String companyCode, String codeId) {
		return HierarchyCodeSelectDTOMapper.map(
				dbPort.select(new CodeId(companyCode, codeId)).orElse(null)
				);
	}

}
