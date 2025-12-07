package com.like.hrm.payitem.adapter.in.web.payitem;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryDTO;
import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryResultDTO;
import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryUseCase;


@RestController
public class PayItemQueryController {

	PayItemQueryUseCase useCase;
	
	PayItemQueryController(PayItemQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/payitem")
	public ResponseEntity<?> select(PayItemQueryDTO dto) {
								
		List<PayItemQueryResultDTO> list = useCase.query(dto); 
		
		return toList(list, String.format("%d 건 조회되었습니다.", list.size()));
	}
	
}
