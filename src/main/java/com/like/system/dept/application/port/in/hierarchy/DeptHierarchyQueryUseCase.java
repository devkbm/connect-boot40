package com.like.system.dept.application.port.in.hierarchy;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface DeptHierarchyQueryUseCase {
	List<?> query(DeptHierarchyQueryDTO dto);
}
