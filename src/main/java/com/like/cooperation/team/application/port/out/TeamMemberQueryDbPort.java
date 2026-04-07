package com.like.cooperation.team.application.port.out;

import java.util.List;

import com.like.cooperation.team.application.port.in.query.TeamMemberQueryResultDTO;

public interface TeamMemberQueryDbPort {

	List<TeamMemberQueryResultDTO> getTeamMemberList(Long teamId);
}
