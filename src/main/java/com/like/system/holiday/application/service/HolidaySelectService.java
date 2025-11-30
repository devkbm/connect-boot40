package com.like.system.holiday.application.service;

import java.time.LocalDate;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Service;

import com.like.system.holiday.application.port.in.select.HolidaySelectDTO;
import com.like.system.holiday.application.port.in.select.HolidaySelectDTOMapper;
import com.like.system.holiday.application.port.in.select.HolidaySelectUseCase;
import com.like.system.holiday.application.port.out.HolidayCommandDbPort;

@Application
@Service
public class HolidaySelectService implements HolidaySelectUseCase {

	HolidayCommandDbPort dbPort;
	
	public HolidaySelectService(HolidayCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public HolidaySelectDTO select(String companyCode, LocalDate date) {		
		return HolidaySelectDTOMapper.toDTO(this.dbPort.select(companyCode, date).orElse(null));
	}
	
}
