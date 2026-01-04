package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryResultDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryUseCase;

@PrimaryAdapter
@RestController
public class HierarchyCodeTreeQueryController {

	HierarchyCodeTreeQueryUseCase useCase;
	
	HierarchyCodeTreeQueryController(HierarchyCodeTreeQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/hierarchycode/treequery") 
	public ResponseEntity<?> getCodeHierarchyList(@ModelAttribute HierarchyCodeTreeQueryDTO searchCondition) {
							
		List<HierarchyCodeTreeQueryResultDTO> list = useCase.getCodeHierarchyList(searchCondition);  						 						
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
