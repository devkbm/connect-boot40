package com.like.system.dept.application.port.in.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface DeptSelectUseCase {
	DeptSelectDTO select(String companyCode, String deptCode);	
}
