package com.like.system.webresource.application.port.out;

import java.util.List;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.webresource.application.port.in.query.WebResourceQueryDTO;
import com.like.system.webresource.application.port.in.query.WebResourceQueryResultDTO;

@SecondaryPort
public interface WebResourceQueryDbPort {
	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto);
}
