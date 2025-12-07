package com.like.hrm.payitem.adapter.in.web.payitemstaff;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.payitem.application.port.in.payitemstaff.save.PayItemStaffSaveDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.save.PayItemStaffSaveUseCase;

import jakarta.validation.Valid;

@RestController
public class PayItemStaffSaveController {

	PayItemStaffSaveUseCase useCase;
	
	PayItemStaffSaveController(PayItemStaffSaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/payitemstaff")
	public ResponseEntity<?> save(@RequestBody @Valid PayItemStaffSaveDTO dto) {			
														
		useCase.save(dto);
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
