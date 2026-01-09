package com.like.system.bizcode.application.port.in.type.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeTypeSaveUseCase {
	void save(BizCodeTypeSaveDTO dto);
}
