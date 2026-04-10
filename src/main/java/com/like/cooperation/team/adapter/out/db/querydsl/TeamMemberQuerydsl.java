package com.like.cooperation.team.adapter.out.db.querydsl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.like.cooperation.team.application.port.in.query.TeamMemberQueryResultDTO;
import com.like.cooperation.team.domain.QTeam;
import com.like.cooperation.team.domain.QTeamMember;
import com.like.cooperation.team.domain.Team;
import com.querydsl.core.Tuple;
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
		
		// 1. Flat 한 데이터 조회
		List<Tuple> rows = queryFactory
				.select(
						qTeam.teamId,
						qTeam.teamName,
						qTeamMember.id.userId					
				)
				.from(qTeam)
				.join(qTeamMember).on(qTeam.teamId.eq(qTeamMember.id.team))
				/*.where(
						qTeam.teamId.eq(teamId)
				)*/				
				.fetch();
		
		// 2. Map을 이용하여 1 : N 객체 변환
		Map<Long, TeamMemberQueryResultDTO> map = new LinkedHashMap<>();
						
		rows.forEach(row -> {
			Long pId = row.get(qTeam.teamId);
			
			// 부모 ID를 기준으로 객체 생성(중복 데이터 제외)
			TeamMemberQueryResultDTO dto = map.computeIfAbsent(
					pId, 
					id -> TeamMemberQueryResultDTO
						.builder()
						.teamId(id.toString())
						.teamName(row.get(qTeam.teamName))
						.list(new ArrayList<>())
						.build()
					);
			
			// 자식 정보가 있다면 추가
			if (row.get(qTeamMember.id.userId) != null) {
				dto.getList().add(
						row.get(qTeamMember.id.userId)						
				);
			}
		});
		
		// 3. Map -> List 변환
		List<TeamMemberQueryResultDTO> list = new ArrayList<>(map.values());
								
		return list;		
	}
	
	
	// Fetch 조인을 이용하여 조회 후 Stream 사용하여 DTO 생성	
	public List<TeamMemberQueryResultDTO> getTeamMemberList_Temp(Long teamId) {
		List<Team> list = queryFactory
				.select(qTeam)
				.from(qTeam)
				.join(qTeam.members, qTeamMember).fetchJoin()				
				.fetch();
		
						
		List<TeamMemberQueryResultDTO> list2 = list.stream()
				.map(e-> TeamMemberQueryResultDTO
						.builder()
						.teamId(e.getTeamId().toString())
						.teamName(e.getTeamName())
						.list(e.getMembers().stream()
								.map(v-> v.getId().getUserId())
								.toList()
							)
						.build()
					)
				.toList();
								
		return list2;
	}
	
}
