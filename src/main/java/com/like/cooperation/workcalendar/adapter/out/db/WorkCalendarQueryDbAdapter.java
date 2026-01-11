package com.like.cooperation.workcalendar.adapter.out.db;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.stereotype.Repository;

import com.like.cooperation.workcalendar.adapter.out.db.querydsl.WorkCalendarQuerydsl;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.calendar.query.WorkCalendarQueryResultDTO;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarQueryDbPort;

@SecondaryAdapter
@Repository
public class WorkCalendarQueryDbAdapter implements WorkCalendarQueryDbPort {
	
	WorkCalendarQuerydsl querydsl;
	
	public WorkCalendarQueryDbAdapter(WorkCalendarQuerydsl querydsl) {
		this.querydsl = querydsl;		
	}
	
	@Override
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(WorkCalendarQueryDTO dto) {
		return querydsl.getWorkGroupList(dto);
	}

	@Override
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(String userId) {
		return querydsl.getWorkGroupList(userId);
	}
	
	
}
