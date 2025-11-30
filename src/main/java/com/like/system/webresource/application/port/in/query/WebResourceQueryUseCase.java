package com.like.system.webresource.application.port.in.query;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface WebResourceQueryUseCase {

	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO condition);
}
