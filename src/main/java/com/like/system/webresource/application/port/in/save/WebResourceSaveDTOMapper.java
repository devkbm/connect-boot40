package com.like.system.webresource.application.port.in.save;

import com.like.system.webresource.domain.WebResource;

public class WebResourceSaveDTOMapper {
	
	public static WebResource newEntity(WebResourceSaveDTO dto) {
		WebResource entity = WebResource.builder()
										.resourceId(dto.resourceId())
										.resourceName(dto.resourceName())
										.resourceType(dto.resourceType())
										.url(dto.url())
										.description(dto.description())
										.build();				
		
		return entity;	
	}
	
	public static WebResource modifyEntity(WebResource entity, WebResourceSaveDTO dto) {
		entity.modifyBuilder()	
			  .resourceName(dto.resourceName())
			  .resourceType(dto.resourceType())
			  .url(dto.url())
			  .description(dto.description())
			  .modify();			
		
		return entity;	
	}	
}
