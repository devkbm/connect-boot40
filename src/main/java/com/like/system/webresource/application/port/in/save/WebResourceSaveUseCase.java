package com.like.system.webresource.application.port.in.save;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WebResourceSaveUseCase {
	void save(WebResourceSaveDTO dto);
	
	boolean exists(String id);
}
