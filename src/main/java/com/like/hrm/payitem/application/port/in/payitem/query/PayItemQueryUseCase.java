package com.like.hrm.payitem.application.port.in.payitem.query;

import java.util.List;

public interface PayItemQueryUseCase {

	List<PayItemQueryResultDTO> query(PayItemQueryDTO dto);
	
}
