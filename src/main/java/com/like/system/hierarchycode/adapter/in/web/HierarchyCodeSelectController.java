package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.port.in.select.HierarchyCodeSelectDTO;
import com.like.system.hierarchycode.application.port.in.select.HierarchyCodeSelectUseCase;

@PrimaryAdapter
@RestController
public class HierarchyCodeSelectController {
	
	HierarchyCodeSelectUseCase useCase;			
		
	public HierarchyCodeSelectController(HierarchyCodeSelectUseCase useCase) {
		this.useCase = useCase;		
	}	
	
	@GetMapping("/api/system/hierarchycode/{codeId}") 
	public ResponseEntity<?> getCode(@RequestParam String companyCode, @PathVariable String codeId) {
								  						 									
		HierarchyCodeSelectDTO dto = useCase.selectCode(companyCode, codeId);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
				
}
