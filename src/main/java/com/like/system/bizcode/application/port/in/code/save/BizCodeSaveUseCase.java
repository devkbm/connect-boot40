package com.like.system.bizcode.application.port.in.code.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface BizCodeSaveUseCase {
	void save(BizCodeSaveDTO dto);
}
