package com.like.cooperation.workcalendar.application.port.in.event.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarEventSaveUseCase {

	void save(WorkCalendarEventSaveDTO dto);
}
