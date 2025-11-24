package com.like.system.dept.application.service;

import org.springframework.stereotype.Service;

import com.like.system.dept.application.port.in.save.DeptSaveDTO;
import com.like.system.dept.application.port.in.save.DeptSaveDTOMapper;
import com.like.system.dept.application.port.in.save.DeptSaveUseCase;
import com.like.system.dept.application.port.out.DeptCommandDbPort;
import com.like.system.dept.domain.Dept;

@Service
public class DeptSaveService implements DeptSaveUseCase {

	DeptCommandDbPort dbPort;
	
	DeptSaveService(DeptCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public boolean exists(String companyCode, String deptCode) {
		return this.dbPort.exists(companyCode, deptCode);
	}

	@Override
	public void save(DeptSaveDTO dto) {			
		Dept entity = null;
		Dept parent = dto.parentDeptCode() != null ? dbPort.select(dto.companyCode(), dto.parentDeptCode()).orElse(null) : null;
		
		if (exists(dto.companyCode(),dto.deptCode())) {
			entity = this.dbPort.select(dto.companyCode(),dto.deptCode()).orElse(null);
			
			DeptSaveDTOMapper.modifyEntity(entity, dto, parent);
			entity.modifiedAppUrl(dto.clientAppUrl());		
		} else {
			entity = DeptSaveDTOMapper.toEntity(dto, parent);
			entity.createdAppUrl(dto.clientAppUrl());
		}		
		
		this.dbPort.save(DeptSaveDTOMapper.toEntity(dto, parent));
	}

}
