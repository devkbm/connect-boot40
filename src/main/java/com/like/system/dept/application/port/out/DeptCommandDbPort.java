package com.like.system.dept.application.port.out;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.dept.domain.Dept;

@SecondaryPort
public interface DeptCommandDbPort {

	boolean exists(String companyCode, String deptCode);
	
	Optional<Dept> select(String companyCode, String deptCode);
	
	void save(Dept entity);
	
	void delete(String companyCode, String deptCode);
}
