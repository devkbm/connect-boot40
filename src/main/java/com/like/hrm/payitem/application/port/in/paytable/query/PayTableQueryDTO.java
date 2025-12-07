package com.like.hrm.payitem.application.port.in.paytable.query;

import java.time.LocalDate;

public record PayTableQueryDTO(
		String companyCode,
		String payItemCode,
		LocalDate effectiveDate
		) {

}
