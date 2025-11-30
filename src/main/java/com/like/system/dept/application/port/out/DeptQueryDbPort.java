package com.like.system.dept.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.dept.application.port.in.query.DeptQueryDTO;
import com.like.system.dept.domain.Dept;

@SecondaryPort
public interface DeptQueryDbPort {
	
	List<Dept> select(DeptQueryDTO dto);
}
