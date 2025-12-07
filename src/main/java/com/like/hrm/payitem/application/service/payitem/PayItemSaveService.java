package com.like.hrm.payitem.application.service.payitem;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitem.save.PayItemSaveDTO;
import com.like.hrm.payitem.application.port.in.payitem.save.PayItemSaveDTOMapper;
import com.like.hrm.payitem.application.port.in.payitem.save.PayItemSaveUseCase;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.payitem.PayItem;
import com.like.hrm.payitem.domain.payitem.PayItemId;

@Service
public class PayItemSaveService implements PayItemSaveUseCase {

	PayItemCommandDbPort dbPort;
	
	PayItemSaveService(PayItemCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(PayItemSaveDTO dto) {
		PayItem entity = this.dbPort.select(new PayItemId(dto.companyCode(), dto.payItemCode())).orElse(null);
		
		if (entity == null) {
			entity = PayItemSaveDTOMapper.newEntity(dto);
		} else {
			entity = PayItemSaveDTOMapper.modifyEntity(entity, dto);
		}
		
		dbPort.save(entity);		
	}
	
}
