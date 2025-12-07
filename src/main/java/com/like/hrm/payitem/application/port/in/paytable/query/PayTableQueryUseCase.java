package com.like.hrm.payitem.application.port.in.paytable.query;

import java.util.List;

public interface PayTableQueryUseCase {

	List<PayTableQueryResultDTO> query(PayTableQueryDTO dto);
	
}
