package com.like.system.webresource.application.port.in.query;

public record WebResourceQueryDTO(
		String resourceCode,
		String resourceName,
		String resourceType,
		String url,
		String description
		) {		
}
