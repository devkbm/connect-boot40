package com.like.cooperation.workcalendar.application.port.out;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.cooperation.workcalendar.domain.WorkCalendarEvent;

@SecondaryPort
public interface WorkCalendarEventCommandDbPort {
	WorkCalendarEvent select(Long id);
	
	void save(WorkCalendarEvent entity);
	
	void delete(Long id); 
}
