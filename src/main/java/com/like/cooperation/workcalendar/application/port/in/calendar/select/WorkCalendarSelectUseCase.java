package com.like.cooperation.workcalendar.application.port.in.calendar.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarSelectUseCase {

	WorkCalendarSelectDTO select(Long id);
}
