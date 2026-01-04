package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.port.in.save.HierarchyCodeSaveDTO;
import com.like.system.hierarchycode.application.port.in.save.HierarchyCodeSaveUseCase;

@PrimaryAdapter
@RestController
public class HierarchyCodeSaveController {
	
	HierarchyCodeSaveUseCase useCase;			
		
	public HierarchyCodeSaveController(HierarchyCodeSaveUseCase useCase) {
		this.useCase = useCase;
	}	
				
	@PostMapping("/api/system/hierarchycode")
	public ResponseEntity<?> saveCode(@RequestBody HierarchyCodeSaveDTO dto) {					
		
		useCase.save(dto);		
											 				
		return toOne(null, MessageUtil.getSaveMessage(1));
	}	
				
}
