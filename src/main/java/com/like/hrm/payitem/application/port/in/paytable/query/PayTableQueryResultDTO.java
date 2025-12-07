package com.like.hrm.payitem.application.port.in.paytable.query;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PayTableQueryResultDTO {

	String id;
	String companyCode;
	String payItemCode;
	String payItemName;
	LocalDate effectiveDate;
	String occupationCode;
	String occupationName;
	String jobGradeCode;
	String jobGradeName;
	String payStepCode;
	String payStepName;
	BigDecimal wageAmount;
	Boolean isEnable;
	String comment;
	
}
