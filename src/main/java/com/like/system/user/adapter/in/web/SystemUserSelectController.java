package com.like.system.user.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.user.application.port.in.select.SystemUserSelectDTO;
import com.like.system.user.application.port.in.select.SystemUserSelectUseCase;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class SystemUserSelectController {		
				
	private SystemUserSelectUseCase useCase;
		
	public SystemUserSelectController(SystemUserSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	
	@GetMapping("/api/system/user/{userId}")
	public ResponseEntity<?> getUser(@RequestParam String companyCode, @PathVariable String userId) throws FileNotFoundException, IOException {
												
		SystemUserSelectDTO dto = useCase.selectDTO(userId, companyCode);					
		
		ExpressionParser parser = new SpelExpressionParser();
		
		EvaluationContext context = new StandardEvaluationContext(dto);
		context.setVariable("num1", 10);
        //context.setVariable("num2", 20);
		
		String rule = "userId == 'admin' && name == '관리자' && #num1 == 20 ";
		
		// 표현식 구문 분석
		Expression expression = parser.parseExpression(rule);

		// 평가 실행 및 결과 확인 (true 또는 false)
		Boolean result = expression.getValue(context, Boolean.class); // true
				
		log.info(result.toString());
		
		return toOne(dto, MessageUtil.getQueryMessage(1));
	}			
			
}
