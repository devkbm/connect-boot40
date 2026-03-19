package com.like.system.term.application.service.term;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.application.port.in.term.TermSelectDTO;
import com.like.system.term.application.port.in.term.TermSelectDTOMapper;
import com.like.system.term.application.port.in.term.TermSelectUseCase;
import com.like.system.term.application.port.out.TermCommandDbPort;

@Transactional
@Application
@Service
public class TermSelectService implements TermSelectUseCase {

	TermCommandDbPort dbPort;
	
	TermSelectService(TermCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public TermSelectDTO select(String id) {
		return TermSelectDTOMapper.toDTO(this.dbPort.select(id));
	}

}
