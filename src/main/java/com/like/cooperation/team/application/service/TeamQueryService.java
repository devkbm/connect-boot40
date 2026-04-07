package com.like.cooperation.team.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.team.application.port.in.query.TeamMemberQueryResultDTO;
import com.like.cooperation.team.application.port.in.query.TeamMemberQueryUseCase;
import com.like.cooperation.team.application.port.in.query.TeamQueryDTO;
import com.like.cooperation.team.application.port.in.query.TeamQueryResultDTO;
import com.like.cooperation.team.application.port.in.query.TeamQueryUseCase;
import com.like.cooperation.team.application.port.out.TeamMemberQueryDbPort;
import com.like.cooperation.team.application.port.out.TeamQueryDbPort;

@Transactional(readOnly=true)
@Service
public class TeamQueryService implements TeamQueryUseCase, TeamMemberQueryUseCase {

	TeamQueryDbPort dbPort;
	TeamMemberQueryDbPort dbPort2;
	
	public TeamQueryService(TeamQueryDbPort dbPort, TeamMemberQueryDbPort dbPort2) {
		this.dbPort = dbPort;		
		this.dbPort2 = dbPort2;
	}
		
	@Override
	public List<TeamQueryResultDTO> selectTeamList(TeamQueryDTO dto) {
		return this.dbPort.getTeamList(dto);
	}

	@Override
	public List<TeamMemberQueryResultDTO> selectTeamMemeberList(Long id) {
		return dbPort2.getTeamMemberList(id);
	}
		

	/*
	@Override
	public List<SystemUserDTO> selectAllMemberList(SystemUserQueryDTO dto) {
		//return userQueryService.selectList(dto);
		return null;
	}	
	*/
}
