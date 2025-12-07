package com.like.hrm.payitem.adapter.in.web.payitemstaff;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.payitemstaff.select.PayItemStaffSelectDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.select.PayItemStaffSelectUseCase;

@RestController
public class PayItemStaffSelectController {

	PayItemStaffSelectUseCase useCase;
	
	PayItemStaffSelectController(PayItemStaffSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/payitemstaff/{id}")
	public ResponseEntity<?> select(@PathVariable String id) {
								
		PayItemStaffSelectDTO dto = useCase.select(Long.parseLong(id)); 
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
	
}
