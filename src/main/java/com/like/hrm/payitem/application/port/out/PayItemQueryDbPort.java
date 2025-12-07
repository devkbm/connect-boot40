package com.like.hrm.payitem.application.port.out;

import java.util.List;

import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryDTO;
import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryResultDTO;

public interface PayItemQueryDbPort {

	List<PayItemQueryResultDTO> query(PayItemQueryDTO dto);
}
