package com.like.hrm.payitem.adapter.in.web.payitemstaff;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryResultDTO;
import com.like.hrm.payitem.application.port.in.payitemstaff.query.PayItemStaffQueryUseCase;

@RestController
public class PayItemStaffQueryController {

	PayItemStaffQueryUseCase useCase;
	
	PayItemStaffQueryController(PayItemStaffQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/payitemstaff")
	public ResponseEntity<?> select(PayItemStaffQueryDTO dto) {
								
		List<PayItemStaffQueryResultDTO> list = useCase.query(dto); 
		
		return toList(list, String.format("%d 건 조회되었습니다.", list.size()));
	}
	
}
