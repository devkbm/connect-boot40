package com.like.system.holiday.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HolidaySaveUseCase {
	void save(HolidaySaveDTO dto);
}
