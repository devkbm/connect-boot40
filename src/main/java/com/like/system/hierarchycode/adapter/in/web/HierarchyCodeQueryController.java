package com.like.system.hierarchycode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.hierarchycode.application.dto.HierarchyCodeQueryDTO;
import com.like.system.hierarchycode.application.port.in.query.HierarchyCodeQueryResultDTO;
import com.like.system.hierarchycode.application.port.in.query.HierarchyCodeQueryUseCase;


@PrimaryAdapter
@RestController
public class HierarchyCodeQueryController {

	HierarchyCodeQueryUseCase useCase;
	
	HierarchyCodeQueryController(HierarchyCodeQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/hierarchycode") 
	public ResponseEntity<?> getCodeList(@ModelAttribute HierarchyCodeQueryDTO searchCondition) {									  						 						
		
		List<HierarchyCodeQueryResultDTO> dtoList = this.useCase.query();
		
		return toList(dtoList, MessageUtil.getQueryMessage(dtoList.size()));
	}
	
}
