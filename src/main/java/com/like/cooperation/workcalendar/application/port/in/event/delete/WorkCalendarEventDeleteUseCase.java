package com.like.cooperation.workcalendar.application.port.in.event.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarEventDeleteUseCase {
	void delete(Long id);
}
