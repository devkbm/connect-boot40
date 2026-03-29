package com.like.system.webresource.application.port.in.select;

import com.like.system.webresource.domain.WebResource;

public class WebResourceFormSelectDTOMapper {

	public static WebResourceFormSelectDTO toDTO(WebResource entity) {
		
		if (entity == null) return null; 
		
		
		return WebResourceFormSelectDTO
					.builder()				    
				    .resourceId(entity.id())
				    .resourceName(entity.name())
				    .resourceType(entity.type())
				    .url(entity.url())
				    .description(entity.description())
				    .build();
	}
		
}
