package com.like.hrm.payitem.application.port.in.payitemstaff.query;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PayItemStaffQueryResultDTO {

	String id;
	String companyCode;
	String staffNo;
	String staffName;
	String payItemCode;
	String payItemName;
	LocalDate from;
	LocalDate to;
	BigDecimal wageAmount;
	String comment;
	
}

