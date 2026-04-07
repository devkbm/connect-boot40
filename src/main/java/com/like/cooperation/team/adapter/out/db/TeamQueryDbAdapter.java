package com.like.cooperation.team.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.adapter.out.db.querydsl.TeamQuerydsl;
import com.like.cooperation.team.application.port.in.query.TeamQueryDTO;
import com.like.cooperation.team.application.port.in.query.TeamQueryResultDTO;
import com.like.cooperation.team.application.port.out.TeamQueryDbPort;

@Repository
public class TeamQueryDbAdapter implements TeamQueryDbPort {

	TeamQuerydsl query;
	
	TeamQueryDbAdapter(TeamQuerydsl query) {
		this.query = query;
	}
	
	@Override
	public List<TeamQueryResultDTO> getTeamList(TeamQueryDTO dto) {
		return this.query.getTeamList(dto);
	}
	
}
