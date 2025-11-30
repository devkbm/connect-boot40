package com.like.system.company.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.application.port.in.save.CompanySaveDTO;
import com.like.system.company.application.port.in.save.CompanySaveDTOMapstruct;
import com.like.system.company.application.port.in.save.CompanySaveUseCase;
import com.like.system.company.application.port.out.CompanyCommandDbPort;
import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.CompanyInfoId;

@Transactional
@Application
@Service
public class CompanySaveService implements CompanySaveUseCase {

	CompanyCommandDbPort dbPort;
	
	CompanySaveService(CompanyCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(CompanySaveDTO dto) {
		CompanyInfo entity = null;
				
		if (exists(dto.companyCode())) {
			entity = CompanySaveDTOMapstruct.INSTANCE.toEntity(dto);
			entity.modifiedAppUrl(dto.clientAppUrl());
		} else {
			entity = CompanySaveDTOMapstruct.INSTANCE.toEntity(dto);
			
			entity.createdAppUrl(dto.clientAppUrl());
		}
		
		this.dbPort.save(entity);
	}
	
	private boolean exists(String id) {
		return this.dbPort.exists(new CompanyInfoId(id));
	}

}
