package com.like.hrm.payitem.adapter.out.db.payitem.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryDTO;
import com.like.hrm.payitem.application.port.in.payitem.query.PayItemQueryResultDTO;
import com.like.hrm.payitem.domain.payitem.QPayItem;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PayItemQuerydsl {

	final QPayItem qPayItem = QPayItem.payItem;
	
	JPAQueryFactory queryFactory;
	
	PayItemQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
		
	public List<PayItemQueryResultDTO> query(PayItemQueryDTO dto) {
		return queryFactory
				.select(Projections.fields(PayItemQueryResultDTO.class,						
						qPayItem.id.companyCode.as("companyCode"),
						qPayItem.id.payItemCode.as("payItemCode"),
						qPayItem.payItemName,
						qPayItem.type,
						qPayItem.usePayTable,
						qPayItem.seq,						
						qPayItem.comment							
						)
				)
				.from(qPayItem)
				.fetch();	
	}

}
