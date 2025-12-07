package com.like.cooperation.workcalendar.application.port.in.calendar.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WorkCalendarDeleteUseCase {
	void delete(Long id);
}
