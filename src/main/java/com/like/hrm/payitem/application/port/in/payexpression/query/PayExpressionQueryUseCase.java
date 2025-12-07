package com.like.hrm.payitem.application.port.in.payexpression.query;

import java.util.List;

public interface PayExpressionQueryUseCase {

	List<PayExpressionQueryResultDTO> query(PayExpressionQueryDTO dto);
}
