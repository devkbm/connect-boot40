package com.like.cooperation.workcalendar.adapter.out.db;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.cooperation.workcalendar.adapter.out.db.querydsl.WorkCalendarEventQuerydsl;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarEventQueryDbPort;

@SecondaryAdapter
@Repository
public class WorkCalendarEventQueryDbAdapter implements WorkCalendarEventQueryDbPort {
		
	WorkCalendarEventQuerydsl querydsl;
	
	public WorkCalendarEventQueryDbAdapter(WorkCalendarEventQuerydsl querydsl) {			
		this.querydsl = querydsl;
	}	

	@Override
	public List<WorkCalendarEventQueryResultDTO> getScheduleList2(WorkCalendarEventQueryDTO dto) {
		return this.querydsl.getScheduleList(dto);
	}
	
}
