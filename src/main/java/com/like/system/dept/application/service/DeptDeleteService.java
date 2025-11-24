package com.like.system.dept.application.service;

import org.springframework.stereotype.Service;

import com.like.system.dept.application.port.in.delete.DeptDeleteUseCase;
import com.like.system.dept.application.port.out.DeptCommandDbPort;


@Service
public class DeptDeleteService implements DeptDeleteUseCase {

	DeptCommandDbPort dbPort;
	
	public DeptDeleteService(DeptCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}			

	@Override
	public void delete(String companyCode, String deptCode) {
		this.dbPort.delete(companyCode, deptCode);		
	}
	
}
