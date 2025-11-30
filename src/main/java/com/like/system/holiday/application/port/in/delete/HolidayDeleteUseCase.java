package com.like.system.holiday.application.port.in.delete;

import java.time.LocalDate;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HolidayDeleteUseCase {
	void delete(String companyCode, LocalDate date);
}
