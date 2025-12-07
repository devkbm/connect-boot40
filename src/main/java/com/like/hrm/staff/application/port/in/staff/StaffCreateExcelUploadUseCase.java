package com.like.hrm.staff.application.port.in.staff;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface StaffCreateExcelUploadUseCase {

	void upload(List<StaffCreateExcelUploadDTO> dtos);
}
