package com.like.system.holiday.application.port.in.save;

import com.like.system.holiday.domain.Holiday;
import com.like.system.holiday.domain.HolidayId;

public class HolidaySaveDTOMapper {
	
	public static Holiday newEntity(HolidaySaveDTO dto) {	
		
		Holiday entity = new Holiday(new HolidayId(dto.companyCode(), dto.date()), dto.holidayName(), dto.comment());
		
		entity.createdAppUrl(dto.clientAppUrl());
		
		return entity;
	}
	
	public static void modifyEntity(Holiday entity, HolidaySaveDTO dto) {
		entity.modify(dto.holidayName(), dto.comment());
	}
}
