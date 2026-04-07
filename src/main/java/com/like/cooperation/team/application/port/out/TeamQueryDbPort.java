package com.like.cooperation.team.application.port.out;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.application.port.in.query.TeamQueryDTO;
import com.like.cooperation.team.application.port.in.query.TeamQueryResultDTO;

@Repository
public interface TeamQueryDbPort {

	List<TeamQueryResultDTO> getTeamList(TeamQueryDTO dto);	
	
}
