package com.like.hrm.payitem.application.service.payitem;

import org.springframework.stereotype.Service;

import com.like.hrm.payitem.application.port.in.payitem.select.PayItemSelectDTO;
import com.like.hrm.payitem.application.port.in.payitem.select.PayItemSelectDTOMapper;
import com.like.hrm.payitem.application.port.in.payitem.select.PayItemSelectUseCase;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.payitem.PayItemId;

@Service
public class PayItemSelectService implements PayItemSelectUseCase {

	PayItemCommandDbPort dbPort;
	
	PayItemSelectService(PayItemCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public PayItemSelectDTO select(String companyCode, String itemCode) {		
		return PayItemSelectDTOMapper.toDTO(
				this.dbPort.select(new PayItemId(companyCode, itemCode)).orElse(null)
				);
	}
	
	
	
}
