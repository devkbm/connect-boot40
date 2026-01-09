package com.like.system.bizcode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.bizcode.application.port.in.code.select.BizCodeSelectDTO;
import com.like.system.bizcode.application.port.in.code.select.BizCodeSelectUseCase;

@PrimaryAdapter
@RestController
public class BizCodeSelectController {

	private BizCodeSelectUseCase service;
	
	public BizCodeSelectController(BizCodeSelectUseCase service) {
		this.service = service;
	}
		
	@GetMapping("/api/system/bizcodetype/{typeId}/bizcode/{code}")
	public ResponseEntity<?> getBizCode(@RequestParam String companyCode
									   ,@PathVariable String typeId
									   ,@PathVariable String code) {
		
		BizCodeSelectDTO dto = service.select(companyCode, typeId, code);
					
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}			
	
}
