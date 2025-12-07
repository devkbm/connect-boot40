package com.like.hrm.payitem.application.port.in.payinfo;

public interface PayCalculationUseCase {

	void calc(String companyCode, String payYm, String paySeq, String staffNo);
}
