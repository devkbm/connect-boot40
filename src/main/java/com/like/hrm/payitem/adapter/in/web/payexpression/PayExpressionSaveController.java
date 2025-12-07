package com.like.hrm.payitem.adapter.in.web.payexpression;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.payexpression.save.PayExpressionSaveDTO;
import com.like.hrm.payitem.application.port.in.payexpression.save.PayExpressionSaveUseCase;

import jakarta.validation.Valid;

@RestController
public class PayExpressionSaveController {

	PayExpressionSaveUseCase useCase;
	
	PayExpressionSaveController(PayExpressionSaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/payexpression")
	public ResponseEntity<?> save(@RequestBody @Valid PayExpressionSaveDTO dto) {			
														
		useCase.save(dto);
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
