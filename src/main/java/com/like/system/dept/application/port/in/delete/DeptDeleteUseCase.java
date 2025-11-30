package com.like.system.dept.application.port.in.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface DeptDeleteUseCase {
	void delete(String companyCode, String deptCode);
}
