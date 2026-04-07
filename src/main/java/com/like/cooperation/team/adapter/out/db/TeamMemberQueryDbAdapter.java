package com.like.cooperation.team.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.adapter.out.db.querydsl.TeamMemberQuerydsl;
import com.like.cooperation.team.application.port.in.query.TeamMemberQueryResultDTO;
import com.like.cooperation.team.application.port.out.TeamMemberQueryDbPort;

@Repository
public class TeamMemberQueryDbAdapter implements TeamMemberQueryDbPort {

	TeamMemberQuerydsl query;
	
	TeamMemberQueryDbAdapter(TeamMemberQuerydsl query) {
		this.query = query;
	}
	
	@Override
	public List<TeamMemberQueryResultDTO> getTeamMemberList(Long teamId) {
		return query.getTeamMemberList(teamId);
	}

}
