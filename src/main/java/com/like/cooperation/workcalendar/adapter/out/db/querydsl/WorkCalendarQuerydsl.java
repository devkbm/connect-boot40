package com.like.cooperation.workcalendar.adapter.out.db.querydsl;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryResultDTO;
import com.like.cooperation.workcalendar.domain.QWorkCalendar;
import com.like.cooperation.workcalendar.domain.QWorkCalendarMember;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class WorkCalendarQuerydsl {

	JPAQueryFactory queryFactory;
	
	WorkCalendarQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	final QWorkCalendar qWorkCalendar = QWorkCalendar.workCalendar;
	final QWorkCalendarMember qWorkCalendarMember = QWorkCalendarMember.workCalendarMember;
	
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(String userId) {

		return queryFactory
				.select(Projections.fields(WorkCalendarQueryResultDTO.class,						
						qWorkCalendar.id.stringValue().as("id"),
						qWorkCalendar.name,
						qWorkCalendar.color
						)
				)
				.from(qWorkCalendar)
				.where(qWorkCalendar.id.in(
						   JPAExpressions
                           .select(qWorkCalendarMember.id.workCalendar)
                           .from(qWorkCalendarMember)
                           .where(qWorkCalendarMember.id.userId.eq(userId)))
						)
				.fetch();
		/*
		return queryFactory
				.selectFrom(qWorkCalendar)
				.join(qWorkCalendar.memberList, qWorkCalendarMember)
				.where(qWorkCalendarMember.id.userId.eq(userId))
				.fetch();
		*/
	}
	
	
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(WorkCalendarQueryDTO dto) {
		return queryFactory
				.select(Projections.fields(WorkCalendarQueryResultDTO.class,						
						qWorkCalendar.id.stringValue().as("id"),
						qWorkCalendar.name,
						qWorkCalendar.color
						)
				)
				.from(qWorkCalendar)
				.where(
						likeName(dto.name())
				)
				.fetch();
	}
	
	private BooleanExpression likeName(String name) {
		return hasText(name) ? qWorkCalendar.name.like("%"+name+"%") : null;			
	}
	
	
}
