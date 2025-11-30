package com.like.system.webresource.application.port.out;

import java.util.Optional;

import org.jmolecules.architecture.hexagonal.SecondaryPort;

import com.like.system.webresource.domain.WebResource;

@SecondaryPort
public interface WebResourceCommandDbPort {
	
	boolean exists(String id);
	
	Optional<WebResource> select(String id);
	
	void save(WebResource entity);
	
	void delete(String id);
}
