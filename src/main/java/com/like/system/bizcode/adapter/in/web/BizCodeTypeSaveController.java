package com.like.system.bizcode.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.bizcode.application.port.in.type.save.BizCodeTypeSaveDTO;
import com.like.system.bizcode.application.port.in.type.save.BizCodeTypeSaveUseCase;

@PrimaryAdapter
@RestController
public class BizCodeTypeSaveController {

	private BizCodeTypeSaveUseCase useCase;
	
	public BizCodeTypeSaveController(BizCodeTypeSaveUseCase useCase) {
		this.useCase = useCase;
	}
			
	@PostMapping("/api/system/bizcodetype")	
	public ResponseEntity<?> saveBizCodeType(@RequestBody BizCodeTypeSaveDTO dto) {				
																			
		useCase.save(dto);						
								 					
		return toList(null, MessageUtil.getSaveMessage(1));
	}
	
}
