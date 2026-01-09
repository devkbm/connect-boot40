package com.like.system.bizcode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.bizcode.application.port.in.type.select.BizCodeTypeSelectDTO;
import com.like.system.bizcode.application.port.in.type.select.BizCodeTypeSelectUseCase;

@PrimaryAdapter
@RestController
public class BizCodeTypeSelectController {

	private BizCodeTypeSelectUseCase useCase;
	
	public BizCodeTypeSelectController(BizCodeTypeSelectUseCase useCase) {
		this.useCase = useCase;
	}	
	
	@GetMapping("/api/system/bizcodetype/{typeId}")
	public ResponseEntity<?> getBizCodeType(
			@RequestParam String companyCode,
			@PathVariable String typeId
			) {
		
		BizCodeTypeSelectDTO dto = useCase.select(companyCode, typeId);
					
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}			
}
