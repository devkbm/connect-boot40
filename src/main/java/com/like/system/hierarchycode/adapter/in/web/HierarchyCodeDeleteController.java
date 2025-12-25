package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.service.HierarchyCodeCommandService;

@PrimaryAdapter
@RestController
public class HierarchyCodeDeleteController {
	
	private HierarchyCodeCommandService service;			
		
	public HierarchyCodeDeleteController(HierarchyCodeCommandService service) {
		this.service = service;		
	}	
		
	@DeleteMapping("/api/system/code/{systemtype}/{codeId}")
	public ResponseEntity<?> delCode(@PathVariable String systemtype, @PathVariable String codeId) {						
												
		service.deleteCode(systemtype, codeId);
								 						
		return toOne(null, MessageUtil.getDeleteMessage(1));
	}
	
	
}
