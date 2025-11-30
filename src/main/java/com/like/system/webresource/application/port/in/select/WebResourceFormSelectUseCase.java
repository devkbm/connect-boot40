package com.like.system.webresource.application.port.in.select;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WebResourceFormSelectUseCase {

	WebResourceFormSelectDTO select(String webResourceId);
}
