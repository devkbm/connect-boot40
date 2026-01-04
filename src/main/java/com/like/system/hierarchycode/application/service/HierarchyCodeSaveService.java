package com.like.system.hierarchycode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.hierarchycode.application.port.in.save.HierarchyCodeSaveDTO;
import com.like.system.hierarchycode.application.port.in.save.HierarchyCodeSaveDTOMapper;
import com.like.system.hierarchycode.application.port.in.save.HierarchyCodeSaveUseCase;
import com.like.system.hierarchycode.application.port.out.HierarchyCodeCommandDbPort;
import com.like.system.hierarchycode.domain.Code;
import com.like.system.hierarchycode.domain.CodeId;

@Application
@Service
public class HierarchyCodeSaveService implements HierarchyCodeSaveUseCase {

	HierarchyCodeCommandDbPort dbPort;
	
	HierarchyCodeSaveService(HierarchyCodeCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(HierarchyCodeSaveDTO dto) {
		Code parentCode = findParentCode(dto); 
		Code code = findCode(dto);								
		
		if (code == null) {
			code = HierarchyCodeSaveDTOMapper.newEntity(dto, parentCode);
		} else {
			HierarchyCodeSaveDTOMapper.modifyEntity(code, dto);			
		}
				
		dbPort.save(code);			
	}
	
	private Code findCode(HierarchyCodeSaveDTO dto) {
		if (dto.codeId() == null) return null;
		
		return dbPort.select(new CodeId(dto.companyCode(), dto.codeId())).orElse(null);
	}
	
	private Code findParentCode(HierarchyCodeSaveDTO dto) {
		if (dto.parentId() == null) return null;
		
		return dbPort.select(new CodeId(dto.companyCode(), dto.parentId())).orElse(null);
	}

}
