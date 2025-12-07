package com.like.hrm.payitem.adapter.in.web.payexpression;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.payexpression.select.PayExpressionSelectDTO;
import com.like.hrm.payitem.application.port.in.payexpression.select.PayExpressionSelectUseCase;

@RestController
public class PayExpressionSelectController {

	PayExpressionSelectUseCase useCase;
	
	PayExpressionSelectController(PayExpressionSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/payexpression/{id}")
	public ResponseEntity<?> select(@PathVariable Long id) {
								
		PayExpressionSelectDTO dto = useCase.select(id); 
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
	
}
