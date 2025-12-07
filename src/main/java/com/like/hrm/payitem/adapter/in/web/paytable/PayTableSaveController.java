package com.like.hrm.payitem.adapter.in.web.paytable;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.paytable.save.PayTableSaveDTO;
import com.like.hrm.payitem.application.port.in.paytable.save.PayTableSaveUseCase;

import jakarta.validation.Valid;

@RestController
public class PayTableSaveController {

	PayTableSaveUseCase useCase;
	
	PayTableSaveController(PayTableSaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/paytable")
	public ResponseEntity<?> save(@RequestBody @Valid PayTableSaveDTO dto) {			
														
		useCase.save(dto);
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}
	
}
