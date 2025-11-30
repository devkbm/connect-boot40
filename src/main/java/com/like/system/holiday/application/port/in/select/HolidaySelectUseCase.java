package com.like.system.holiday.application.port.in.select;

import java.time.LocalDate;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HolidaySelectUseCase {
	HolidaySelectDTO select(String companyCode, LocalDate date);
}
