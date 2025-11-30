package com.like.system.holiday.application.port.out;

import java.time.LocalDate;
import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.holiday.domain.Holiday;

@SecondaryPort
public interface HolidayCommandDbPort {

	boolean exists(String companyCode, LocalDate date);
	
	Optional<Holiday> select(String companyCode, LocalDate date);
	
	void save(Holiday entity);
	
	void delete(String companyCode, LocalDate date);
}
