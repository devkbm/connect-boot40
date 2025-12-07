package com.like.cooperation.workcalendar.application.service;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.cooperation.workcalendar.application.port.in.calendar.delete.WorkCalendarDeleteUseCase;
import com.like.cooperation.workcalendar.application.port.out.WorkCalendarCommandDbPort;

@Application
@Transactional
@Service
public class WorkCalendarDeleteService implements WorkCalendarDeleteUseCase {

	WorkCalendarCommandDbPort dbPort;
	
	WorkCalendarDeleteService(WorkCalendarCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void delete(Long id) {
		this.dbPort.delete(id);		
	}

}
