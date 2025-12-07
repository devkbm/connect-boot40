package com.like.hrm.payitem.adapter.out.db.paytable.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.hrmcode.domain.QHrmCode;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryDTO;
import com.like.hrm.payitem.application.port.in.paytable.query.PayTableQueryResultDTO;
import com.like.hrm.payitem.domain.payitem.QPayItem;
import com.like.hrm.payitem.domain.paytable.QPayTable;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PayTableQuerydsl {

	final QPayTable qPayTable = QPayTable.payTable;
	final QPayItem qPayItem = QPayItem.payItem;
	
	JPAQueryFactory queryFactory;
	
	PayTableQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<PayTableQueryResultDTO> query(PayTableQueryDTO dto) {
		
		QHrmCode occupationCode = new QHrmCode("occupationCode");
		QHrmCode jobGradeCode = new QHrmCode("jobGradeCode");
		QHrmCode payStepCode = new QHrmCode("payStepCode");
		
		return this.queryFactory
				.select(Projections.fields(PayTableQueryResultDTO.class,
						qPayTable.id.stringValue().as("id"),
						qPayTable.companyCode,
						qPayTable.payItemCode,
						qPayItem.payItemName.as("payItemName"),
						qPayTable.effectiveDate,
						qPayTable.occupationCode,
						occupationCode.codeName.as("occupationName"),
						qPayTable.jobGradeCode,
						jobGradeCode.codeName.as("jobGradeName"),
						qPayTable.payStepCode,
						payStepCode.codeName.as("payStepName"),
						qPayTable.wageAmount,
						qPayTable.isEnable,
						qPayTable.comment							
					)
				)
				.from(qPayTable)
				.innerJoin(qPayItem)
					.on(qPayItem.id.companyCode.eq(qPayTable.companyCode)
						.and(qPayItem.id.payItemCode.eq(qPayTable.payItemCode))
					)
				.leftJoin(occupationCode)
			   		.on(occupationCode.id.typeId.eq("HR0003")
			   		.and(qPayTable.occupationCode.eq(occupationCode.id.code)))
			   	.leftJoin(jobGradeCode)
			   		.on(jobGradeCode.id.typeId.eq("HR0004")
			   		.and(qPayTable.jobGradeCode.eq(jobGradeCode.id.code)))
			   	.leftJoin(payStepCode)
			   		.on(payStepCode.id.typeId.eq("HR0005")
			   		.and(qPayTable.payStepCode.eq(payStepCode.id.code)))
				.fetch();
	}
}
