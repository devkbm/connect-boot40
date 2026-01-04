package com.like.system.hierarchycode.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface HierarchyCodeSaveUseCase {

	void save(HierarchyCodeSaveDTO dto);
}
