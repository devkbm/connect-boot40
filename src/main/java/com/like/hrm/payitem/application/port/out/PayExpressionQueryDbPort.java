package com.like.hrm.payitem.application.port.out;

import java.util.List;

import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryDTO;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryResultDTO;

public interface PayExpressionQueryDbPort {
	List<PayExpressionQueryResultDTO> query(PayExpressionQueryDTO dto);
}
