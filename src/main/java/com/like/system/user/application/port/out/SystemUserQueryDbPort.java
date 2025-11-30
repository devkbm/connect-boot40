package com.like.system.user.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.user.application.port.in.query.SystemUserQueryDTO;
import com.like.system.user.application.port.in.query.SystemUserQueryResultDTO;

@SecondaryPort
public interface SystemUserQueryDbPort {
	List<SystemUserQueryResultDTO> selectList(SystemUserQueryDTO dto);
}
