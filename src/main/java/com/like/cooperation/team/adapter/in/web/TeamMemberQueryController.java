package com.like.cooperation.team.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.cooperation.team.application.port.in.query.TeamMemberQueryResultDTO;
import com.like.cooperation.team.application.port.in.query.TeamMemberQueryUseCase;
import com.like.core.message.MessageUtil;

@RestController
public class TeamMemberQueryController {

	TeamMemberQueryUseCase useCase;
	
	TeamMemberQueryController(TeamMemberQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/grw/team/{id}/member")
	public ResponseEntity<?> getTeamMemberList(@PathVariable Long id) {
						
		List<TeamMemberQueryResultDTO> list = useCase.selectTeamMemeberList(id);				
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));												
	}
	
}
