package com.like.hrm.payitem.application.port.out;

import java.util.List;

import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryDTO;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryResultDTO;

public interface PayTableQueryDbPort {

	List<PayTableQueryResultDTO> query(PayTableQueryDTO dto);
}
