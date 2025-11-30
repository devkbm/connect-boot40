package com.like.system.webresource.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.webresource.application.port.in.save.WebResourceSaveUseCase;
import com.like.system.webresource.application.port.in.save.WebResourceSaveDTO;
import com.like.system.webresource.application.port.in.save.WebResourceSaveDTOMapper;
import com.like.system.webresource.application.port.out.WebResourceCommandDbPort;
import com.like.system.webresource.domain.WebResource;

import jakarta.persistence.EntityNotFoundException;

@Application
@Service
public class WebResourceSaveService implements WebResourceSaveUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceSaveService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(WebResourceSaveDTO dto) {	
		WebResource entity = null;
		
		if (exists(dto.resourceId())) {
			entity = this.port.select(dto.resourceId())
							  .orElseThrow(() -> new EntityNotFoundException(dto.resourceId() +" 웹리소스 정보가 존재하지 않습니다."));			
			entity = WebResourceSaveDTOMapper.modifyEntity(entity, dto); 
			
			entity.modifiedAppUrl(dto.clientAppUrl());			
		} else {
			entity = WebResourceSaveDTOMapper.newEntity(dto);
			
			entity.createdAppUrl(dto.clientAppUrl());
		}
		
		this.port.save(entity);		
	}

	@Override
	public boolean exists(String id) {
		return this.port.exists(id);
	}
}
