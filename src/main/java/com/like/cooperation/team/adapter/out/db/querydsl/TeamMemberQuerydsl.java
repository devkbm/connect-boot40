package com.like.cooperation.team.adapter.out.db.querydsl;

import java.util.List;

import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Repository;

import com.like.cooperation.team.application.port.in.query.TeamMemberQueryResultDTO;
import com.like.cooperation.team.domain.QTeam;
import com.like.cooperation.team.domain.QTeamMember;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;



@Repository
public class TeamMemberQuerydsl {

	private JPAQueryFactory queryFactory;
	private final QTeam qTeam = QTeam.team;
	private final QTeamMember qTeamMember = QTeamMember.teamMember;
		
	TeamMemberQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<TeamMemberQueryResultDTO> getTeamMemberList(Long teamId) {
		
		List<TeamMemberQueryResultDTO> list = queryFactory
				.select(Projections.fields(TeamMemberQueryResultDTO.class,
						qTeam.teamId.stringValue().as("teamId"),
						qTeam.teamName,
						qTeamMember.id.userId.as("userId")
						)
				)
				.from(qTeam)
				.join(qTeamMember).on(qTeam.teamId.eq(qTeamMember.id.team))
				.where(
						qTeam.teamId.eq(teamId)
				)
				.fetch();
				
						
		ListUtils.transformedList(list, e -> new TeamMemberQueryResultDTO());		
		
		return list;	
	}
}
