package com.like.cooperation.workcalendar.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryDTO;
import com.like.cooperation.workcalendar.application.port.in.event.query.WorkCalendarEventQueryResultDTO;

@SecondaryPort
public interface WorkCalendarEventQueryDbPort {
	
	List<WorkCalendarEventQueryResultDTO> getScheduleList2(WorkCalendarEventQueryDTO dto);
	
}
