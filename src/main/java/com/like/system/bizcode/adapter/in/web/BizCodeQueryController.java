package com.like.system.bizcode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.bizcode.application.port.in.code.query.BizCodeQueryResultDTO;
import com.like.system.bizcode.application.port.in.code.query.BizCodeQueryUseCase;

@PrimaryAdapter
@RestController
public class BizCodeQueryController {
	
	BizCodeQueryUseCase useCase;
	
	BizCodeQueryController(BizCodeQueryUseCase useCase) {
		this.useCase = useCase;
	}

	@GetMapping("/api/system/bizcodetype/{typeId}/bizcode")
	public ResponseEntity<?> getBizCodeList(
			@RequestParam String companyCode,
			@PathVariable String typeId
			) {
		
		List<BizCodeQueryResultDTO> list = useCase.query(companyCode, typeId);											   
					
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
