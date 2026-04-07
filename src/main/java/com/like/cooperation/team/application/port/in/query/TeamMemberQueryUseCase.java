package com.like.cooperation.team.application.port.in.query;

import java.util.List;

public interface TeamMemberQueryUseCase {

	List<TeamMemberQueryResultDTO> selectTeamMemeberList(Long id);
}
