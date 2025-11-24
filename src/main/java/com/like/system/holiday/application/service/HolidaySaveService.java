package com.like.system.holiday.application.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.like.system.holiday.application.port.in.save.HolidaySaveDTO;
import com.like.system.holiday.application.port.in.save.HolidaySaveDTOMapper;
import com.like.system.holiday.application.port.in.save.HolidaySaveUseCase;
import com.like.system.holiday.application.port.out.HolidayCommandDbPort;
import com.like.system.holiday.domain.Holiday;

@Service
public class HolidaySaveService implements HolidaySaveUseCase {

	HolidayCommandDbPort dbPort;
	
	public HolidaySaveService(HolidayCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(HolidaySaveDTO dto) {		
		Holiday entity = null;
		
		if (exists(dto.companyCode(), dto.date())) {
			 entity = this.dbPort.select(dto.companyCode(), dto.date()).orElse(entity);
			HolidaySaveDTOMapper.modifyEntity(entity, dto);
		} else {
			entity = HolidaySaveDTOMapper.newEntity(dto);
		}
		
		this.dbPort.save(entity);
	}
	
	private boolean exists(String companyCode, LocalDate date) {
		return this.dbPort.exists(companyCode, date);
	}

}
