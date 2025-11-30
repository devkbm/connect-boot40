package com.like.system.user.application.port.in.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SystemUserQueryUseCase {	
	List<SystemUserQueryResultDTO> selectList(SystemUserQueryDTO dto);
}
