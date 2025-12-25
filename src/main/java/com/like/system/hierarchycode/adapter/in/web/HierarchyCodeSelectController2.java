package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.dto.HierarchySaveDTO;
import com.like.system.hierarchycode.application.service.HierarchyCodeCommandService;
import com.like.system.hierarchycode.domain.Code;

@PrimaryAdapter
@RestController
public class HierarchyCodeSelectController2 {
	
	private HierarchyCodeCommandService service;			
		
	public HierarchyCodeSelectController2(HierarchyCodeCommandService service) {
		this.service = service;		
	}	
	
	@GetMapping("/api/system/code/{systemtype}/{codeId}") 
	public ResponseEntity<?> getCode(@PathVariable String systemtype, @PathVariable String codeId) {
								  						 					
		Code entity = service.getCode(systemtype, codeId);
		
		HierarchySaveDTO dto = HierarchySaveDTO.convertDTO(entity);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
				
}
