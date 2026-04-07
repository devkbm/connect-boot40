package com.like.cooperation.team.application.port.in.query;

import java.util.List;

public interface TeamQueryUseCase {
	List<TeamQueryResultDTO> selectTeamList(TeamQueryDTO dto);
			
	//List<SystemUserDTO> selectAllMemberList(SystemUserQueryDTO dto);
}
