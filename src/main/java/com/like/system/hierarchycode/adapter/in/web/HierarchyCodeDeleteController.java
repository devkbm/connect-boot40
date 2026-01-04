package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.port.in.delete.HierarchyCodeDeleteUseCase;

@PrimaryAdapter
@RestController
public class HierarchyCodeDeleteController {
	
	HierarchyCodeDeleteUseCase useCase;			
		
	public HierarchyCodeDeleteController(HierarchyCodeDeleteUseCase useCase) {
		this.useCase = useCase;		
	}	
		
	@DeleteMapping("/api/system/hierarchycode/{codeId}")
	public ResponseEntity<?> delCode(@RequestParam String companyCode, @PathVariable String codeId) {						
												
		useCase.delete(companyCode, codeId);
								 						
		return toOne(null, MessageUtil.getDeleteMessage(1));
	}
	
	
}
