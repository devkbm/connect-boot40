package com.like.cooperation.workcalendar.application.port.out;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.workcalendar.domain.WorkCalendar;

@SecondaryPort
public interface WorkCalendarCommandDbPort {
	WorkCalendar select(Long id);
	
	void save(WorkCalendar entity);
	
	void delete(Long id);
}
