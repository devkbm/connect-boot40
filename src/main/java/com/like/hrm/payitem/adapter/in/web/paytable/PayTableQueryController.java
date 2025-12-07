package com.like.hrm.payitem.adapter.in.web.paytable;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryDTO;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryResultDTO;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryUseCase;

@RestController
public class PayTableQueryController {

	PayTableQueryUseCase useCase;
	
	PayTableQueryController(PayTableQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/paytable")
	public ResponseEntity<?> select(PayTableQueryDTO dto) {
								
		List<PayTableQueryResultDTO> list = useCase.query(dto); 
		
		return toList(list, String.format("%d 건 조회되었습니다.", list.size()));
	}
	
}
