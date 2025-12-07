package com.like.hrm.payitem.application.port.in.payitemstaff.select;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Builder;

@Builder
public record PayItemStaffSelectDTO(
		String clientAppUrl,
		String id,
		String companyCode,
		String staffNo,
		String payItemCode,
		LocalDate fromDt,
		LocalDate toDt,		
		BigDecimal wageAmount,		
		String comment
		) {

}
