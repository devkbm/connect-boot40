package com.like.system.hierarchycode.application.port.in.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HierarchyCodeSelectUseCase {
	HierarchyCodeSelectDTO selectCode(String companyCode, String codeId);
}
