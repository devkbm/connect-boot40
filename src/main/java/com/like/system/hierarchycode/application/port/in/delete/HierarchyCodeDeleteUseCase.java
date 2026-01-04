package com.like.system.hierarchycode.application.port.in.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HierarchyCodeDeleteUseCase {
	void delete(String companyCode, String codeId);
}
