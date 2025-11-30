package com.like.system.systemcode.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeSaveUseCase {
	void save(BizCodeTypeSaveDTO dto);
}
