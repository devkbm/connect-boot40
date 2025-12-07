package com.like.hrm.payitem.application.port.in.payitem.query;

import lombok.Data;

@Data
public class PayItemQueryResultDTO {

	String companyCode;
	String payItemCode;
	String payItemName;
	String type;
	Boolean usePayTable;
	Integer seq;
	String comment;
	
}
