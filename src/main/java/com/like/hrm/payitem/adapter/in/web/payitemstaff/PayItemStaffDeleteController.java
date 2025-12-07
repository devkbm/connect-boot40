package com.like.hrm.payitem.adapter.in.web.payitemstaff;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.payitemstaff.delete.PayItemStaffDeleteUseCase;

@RestController
public class PayItemStaffDeleteController {

	PayItemStaffDeleteUseCase useCase;
	
	PayItemStaffDeleteController(PayItemStaffDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	@DeleteMapping("/api/hrm/payitemstaff/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
								
		useCase.delete(Long.parseLong(id)); 
		
		return toOne(null, MessageUtil.getDeleteMessage(1));
	}
}
