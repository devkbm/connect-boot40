package com.like.hrm.payitem.adapter.in.web.payexpression;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryDTO;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryResultDTO;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryUseCase;

@RestController
public class PayExpressionQueryController {

	PayExpressionQueryUseCase useCase;
	
	PayExpressionQueryController(PayExpressionQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/payexpression")
	public ResponseEntity<?> select(PayExpressionQueryDTO dto) {
								
		List<PayExpressionQueryResultDTO> list = useCase.query(dto); 
		
		return toList(list, String.format("%d 건 조회되었습니다.", list.size()));
	}
	
}
