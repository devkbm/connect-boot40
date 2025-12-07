package com.like.cooperation.workcalendar.application.port.in.event.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarEventSelectUseCase {
	WorkCalendarEventResponseDTO select(Long id);
}
