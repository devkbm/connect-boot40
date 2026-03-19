package com.like.system.term.application.service.term;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.application.port.in.term.TermSaveDTO;
import com.like.system.term.application.port.in.term.TermSaveDTOMapper;
import com.like.system.term.application.port.in.term.TermSaveUseCase;
import com.like.system.term.application.port.out.DataDomainCommandDbPort;
import com.like.system.term.application.port.out.TermCommandDbPort;
import com.like.system.term.domain.DataDomainDictionary;
import com.like.system.term.domain.TermDictionary;


@Transactional
@Application
@Service
public class TermSaveService implements TermSaveUseCase {

	TermCommandDbPort dbPort;	
	DataDomainCommandDbPort dataDomainDbPort;
	
	TermSaveService(
			TermCommandDbPort dbPort,
			DataDomainCommandDbPort dataDomainDbPort
			) {
		this.dbPort = dbPort;		
		this.dataDomainDbPort = dataDomainDbPort;
	}
	
	@Override
	public void save(TermSaveDTO dto) {
		TermDictionary entity = dbPort.select(dto.term());
		
		if (entity == null) {			
			entity = this.createEntity(dto);									
		} else {						  				
			TermSaveDTOMapper.modifyEntity(dto, entity, this.getDataDomainDictionary(dto));
		}
		
		this.dbPort.save(entity);	
	}
	
	private TermDictionary createEntity(TermSaveDTO dto) {		
		DataDomainDictionary dataDomain = this.getDataDomainDictionary(dto);
					 			
		return TermSaveDTOMapper.newEntity(dto, dataDomain);
	}
	
	private DataDomainDictionary getDataDomainDictionary(TermSaveDTO dto) {
		if (dto.dataDomainId() == null) return null;
		
		return dataDomainDbPort.select(dto.dataDomainId());
	}
		
}
