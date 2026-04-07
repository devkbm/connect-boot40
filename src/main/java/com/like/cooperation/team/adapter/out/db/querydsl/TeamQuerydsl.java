package com.like.cooperation.team.adapter.out.db.querydsl;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.application.port.in.query.TeamQueryDTO;
import com.like.cooperation.team.application.port.in.query.TeamQueryResultDTO;
import com.like.cooperation.team.domain.QTeam;
import com.like.cooperation.team.domain.QTeamMember;
import com.like.cooperation.team.domain.TeamMember;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class TeamQuerydsl {

	private JPAQueryFactory queryFactory;
	private final QTeam qTeam = QTeam.team;
	private final QTeamMember qTeamMember = QTeamMember.teamMember;
	
	public TeamQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}

	
	public List<TeamQueryResultDTO> getTeamList(TeamQueryDTO dto) {

		return queryFactory
				.select(Projections.fields(TeamQueryResultDTO.class,
						qTeam.teamId.stringValue().as("teamId"),
						qTeam.teamName
						)
				)
				.from(qTeam)
				.where(
						eqTeamId(dto.teamId()),
						likeTeamName(dto.teamName())
				)
				.fetch();						
	}
		
	
	private BooleanExpression eqTeamId(Long teamId) {
		if (teamId == null) return null;
						
		return qTeam.teamId.eq(teamId);		
	}
	
	private BooleanExpression likeTeamName(String teamName) {
		return hasText(teamName) ? qTeam.teamName.like("%" + teamName + "%") : null;						
	}
	
	public List<TeamMember> getTeamMemberList(Long teamId) {
		return queryFactory.selectFrom(qTeamMember)
						   .where(qTeamMember.team.teamId.eq(teamId))
						   .fetch();
	}	
	
	
	
	
}
