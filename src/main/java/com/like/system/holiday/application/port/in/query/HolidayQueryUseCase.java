package com.like.system.holiday.application.port.in.query;

import java.time.LocalDate;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

import com.like.system.holiday.domain.HolidayInfoCollection;

@PrimaryPort
public interface HolidayQueryUseCase {

	HolidayInfoCollection select(String companyCode, LocalDate fromDate, LocalDate toDate);
}
