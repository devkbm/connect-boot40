package com.like.cooperation.workcalendar.adapter.out.db.querydsl;

import static org.springframework.util.StringUtils.hasText;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryResultDTO;
import com.like.cooperation.workcalendar.domain.QWorkCalendar;
import com.like.cooperation.workcalendar.domain.QWorkCalendarEvent;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class WorkCalendarEventQuerydsl {
	
	JPAQueryFactory queryFactory;
	
	WorkCalendarEventQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	QWorkCalendarEvent qWorkCalendarEvent = QWorkCalendarEvent.workCalendarEvent;
	QWorkCalendar qWorkCalendar = QWorkCalendar.workCalendar;
	
	public List<WorkCalendarEventQueryResultDTO> getScheduleList(WorkCalendarEventQueryDTO dto) {
					
		List<Long> idList = this.changeIdType(dto.fkWorkCalendar());
		
		return queryFactory
				.select(Projections.fields(WorkCalendarEventQueryResultDTO.class, 
						qWorkCalendarEvent.id.stringValue().as("id"),
						qWorkCalendarEvent.title.as("text"),
						qWorkCalendar.color,
						qWorkCalendarEvent.start,
						qWorkCalendarEvent.end,
						qWorkCalendarEvent.allDay
						)
				)
				.from(qWorkCalendarEvent)
				.join(qWorkCalendar)
				.on(qWorkCalendarEvent.workCalendar.eq(qWorkCalendar))
				.where(
						inWorkgroupIds(idList),
						likeTitle(dto.title()),
						between(dto.fromDate(), dto.toDate())						
				)
				.fetch();
	}
	
	private BooleanExpression between(String fromDate, String toDate) {
		
		LocalDateTime fromDateTime = LocalDateTime.of(
				Integer.parseInt(fromDate.substring(0, 4)),Integer.parseInt(fromDate.substring(4, 6)),Integer.parseInt(fromDate.substring(6, 8))
				,0,0,0,0
				);
		
		LocalDateTime toDateTime = LocalDateTime.of(
				Integer.parseInt(toDate.substring(0, 4)),Integer.parseInt(toDate.substring(4, 6)),Integer.parseInt(toDate.substring(6, 8))
				,23,59,59,59
				);
		
		DateTimeExpression<LocalDateTime> fromExpression = Expressions.asDateTime(fromDateTime);
		DateTimeExpression<LocalDateTime> toExpression = Expressions.asDateTime(toDateTime);
		
		return fromExpression.between(qWorkCalendarEvent.start, qWorkCalendarEvent.end)
				.or(toExpression.between(qWorkCalendarEvent.start, qWorkCalendarEvent.end))
				.or(qWorkCalendarEvent.start.between(fromExpression, toExpression))
				.or(qWorkCalendarEvent.end.between(fromExpression, toExpression));
	}
		
	
	private BooleanExpression inWorkgroupIds(List<Long> ids) {
		return CollectionUtils.isEmpty(ids) ? null : qWorkCalendarEvent.workCalendar.id.in(ids);
	}
	
	private BooleanExpression likeTitle(String title) {
		return hasText(title) ? qWorkCalendarEvent.title.like("%"+title+"%") : null;					
	}
	
	/**
	 * 콤마로 구분된 id 매개변수를 List<Long>타입으로 변환한다. 
	 * @param params			ex) 1,2,3
	 * @return List<Long>
	 */
	private List<Long> changeIdType(String params) {		
		String idArray[] = params.split(","); 				
		List<Long> ids = new ArrayList<Long>(idArray.length);
		
		for (int i=0; i<idArray.length; i++) {
			ids.add(Long.parseLong(idArray[i]));
		}	
		
		return ids;
	}
		
}
