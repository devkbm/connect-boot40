package com.like.hrm.payitem.adapter.in.web.payexpression;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.payexpression.delete.PayExpressionDeleteUseCase;

@RestController
public class PayExpressionDeleteController {

	PayExpressionDeleteUseCase useCase;
	
	PayExpressionDeleteController(PayExpressionDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	@DeleteMapping("/api/hrm/payexpression/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
								
		useCase.delete(id); 
		
		return toOne(null, MessageUtil.getDeleteMessage(1));
	}
}
