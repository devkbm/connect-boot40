package com.like.cooperation.team.application.port.in.select;

import com.like.cooperation.team.domain.Team;

public class TeamSelectDTOMapper {

	public static TeamSelectDTO toDTO(Team entity) {					
		
		if (entity == null) return null;
		
		TeamSelectDTO dto = TeamSelectDTO.builder()
									   .createdDt(entity.getCreatedDt())
									   .createdBy(entity.getCreatedBy().getLoggedUser())
									   .modifiedDt(entity.getModifiedDt())
									   .modifiedBy(entity.getModifiedBy().getLoggedUser())
									   .teamId(entity.getTeamId().toString())
									   .teamName(entity.getTeamName())
									   .memberList(entity.getMembers().stream()
																	  .map(r -> r.getId().getUserId())
																	  .toList())																	  
									   .build();		
		return dto;
	}
}
