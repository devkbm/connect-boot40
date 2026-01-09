package com.like.system.bizcode.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.bizcode.application.port.in.type.save.BizCodeTypeSaveDTO;
import com.like.system.bizcode.application.port.in.type.save.BizCodeTypeSaveDTOMapper;
import com.like.system.bizcode.application.port.in.type.save.BizCodeTypeSaveUseCase;
import com.like.system.bizcode.application.port.out.BizCodeTypeCommandDbPort;

@Application
@Service
public class BizCodeTypeSaveService implements BizCodeTypeSaveUseCase {
	BizCodeTypeCommandDbPort port;

	public BizCodeTypeSaveService(BizCodeTypeCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(BizCodeTypeSaveDTO dto) {
		this.port.Save(BizCodeTypeSaveDTOMapper.toEntity(dto));		
	}
}
