package com.like.system.systemcode.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeSaveUseCase {
	void save(BizCodeSaveDTO dto);
}
