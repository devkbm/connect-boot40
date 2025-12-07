package com.like.hrm.payitem.application.service.payexpression;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payexpression.save.PayExpressionSaveDTO;
import com.like.hrm.payitem.application.port.in.payexpression.save.PayExpressionSaveDTOMapper;
import com.like.hrm.payitem.application.port.in.payexpression.save.PayExpressionSaveUseCase;
import com.like.hrm.payitem.application.port.out.PayExpressionCommandDbPort;
import com.like.hrm.payitem.domain.payexpression.PayExpression;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PayExpressionSaveService implements PayExpressionSaveUseCase {

	PayExpressionCommandDbPort dbPort;
	
	PayExpressionSaveService(PayExpressionCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public void save(PayExpressionSaveDTO dto) {			
		PayExpression entity = null;
		
		if (dto.id() == null) {
			entity = PayExpressionSaveDTOMapper.newEntity(dto);
		} else {
			entity = this.dbPort.select(Long.parseLong(dto.id()))
								.orElseThrow(() -> new EntityNotFoundException("엔티티가 존재하지 않습니다."));					
			
			entity = PayExpressionSaveDTOMapper.modifyEntity(entity, dto);
		}
		
		this.dbPort.save(entity);		
	}
	
	
}
