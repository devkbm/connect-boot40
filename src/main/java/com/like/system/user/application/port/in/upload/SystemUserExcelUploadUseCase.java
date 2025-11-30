package com.like.system.user.application.port.in.upload;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface SystemUserExcelUploadUseCase {

	void save(List<SystemUserExcelUploadDTO2> dto);
}
