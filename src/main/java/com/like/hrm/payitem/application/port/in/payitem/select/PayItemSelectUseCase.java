package com.like.hrm.payitem.application.port.in.payitem.select;

public interface PayItemSelectUseCase {
	PayItemSelectDTO select(String companyCode, String itemCode);
}
