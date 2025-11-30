package com.like.system.dept.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface DeptSaveUseCase {
	
	boolean exists(String companyCode, String deptCode);
	
	void save(DeptSaveDTO dto);
}
