package com.like.system.dept.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.dept.domain.DeptHierarchy;

@SecondaryPort
public interface DeptHierarchySelectDbPort {

	List<DeptHierarchy> getAllNodes(String companyCode);
}
