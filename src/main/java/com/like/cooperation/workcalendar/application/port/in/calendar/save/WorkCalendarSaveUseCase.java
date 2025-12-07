package com.like.cooperation.workcalendar.application.port.in.calendar.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarSaveUseCase {
	void save(WorkCalendarSaveDTO dto);
}
