package com.like.hrm.payitem.adapter.in.web.paytable;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.paytable.select.PayTableSelectDTO;
import com.like.hrm.payitem.application.port.in.paytable.select.PayTableSelectUseCase;

@RestController
public class PayTableSelectController {

	PayTableSelectUseCase useCase;
	
	PayTableSelectController(PayTableSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/paytable/{id}")
	public ResponseEntity<?> select(@PathVariable String id) {
								
		PayTableSelectDTO dto = useCase.select(Long.parseLong(id)); 
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
}
