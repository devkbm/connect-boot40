package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.dto.HierarchySaveDTO;
import com.like.system.hierarchycode.application.service.HierarchyCodeCommandService;

@PrimaryAdapter
@RestController
public class HierarchyCodeSaveController {
	
	private HierarchyCodeCommandService service;			
		
	public HierarchyCodeSaveController(HierarchyCodeCommandService service) {
		this.service = service;		
	}	
				
	@PostMapping("/api/system/code")
	public ResponseEntity<?> saveCode(@RequestBody HierarchySaveDTO dto) {					
		
		service.saveCode(dto);		
											 				
		return toOne(null, MessageUtil.getSaveMessage(1));
	}	
				
}
