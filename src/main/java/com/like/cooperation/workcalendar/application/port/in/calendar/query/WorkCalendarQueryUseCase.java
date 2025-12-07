package com.like.cooperation.workcalendar.application.port.in.calendar.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarQueryUseCase {

	public List<WorkCalendarQueryResultDTO> getWorkGroupList(WorkCalendarQueryDTO searchCondition);
	
	public List<WorkCalendarQueryResultDTO> getWorkGroupList(String userId);
}
