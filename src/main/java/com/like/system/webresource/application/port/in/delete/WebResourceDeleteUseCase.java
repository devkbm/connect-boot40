package com.like.system.webresource.application.port.in.delete;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WebResourceDeleteUseCase {
	void delete(String webResourceId);
}
