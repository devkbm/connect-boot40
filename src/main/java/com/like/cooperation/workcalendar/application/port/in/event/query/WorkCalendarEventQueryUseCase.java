package com.like.cooperation.workcalendar.application.port.in.event.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarEventQueryUseCase {

	public List<WorkCalendarEventQueryResultDTO> getScheduleList(WorkCalendarEventQueryDTO searchCondition);
}
