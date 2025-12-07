package com.like.hrm.payitem.adapter.out.db.payexpression.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryDTO;
import com.like.hrm.payitem.application.port.in.payexpression.query.PayExpressionQueryResultDTO;
import com.like.hrm.payitem.domain.payexpression.QPayExpression;
import com.like.hrm.payitem.domain.payitem.QPayItem;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PayExpressionQuerydsl {

	JPAQueryFactory queryFactory;
	final QPayExpression qPayExpression = QPayExpression.payExpression;
	final QPayItem qPayItem = QPayItem.payItem;
		
	PayExpressionQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
			
	public List<PayExpressionQueryResultDTO> query(PayExpressionQueryDTO dto) {
		return queryFactory.select(Projections.fields(PayExpressionQueryResultDTO.class,
					qPayExpression.id.stringValue().as("id"),
					qPayExpression.companyCode,
					qPayExpression.payItemCode,
					qPayItem.payItemName,
					qPayExpression.payCondition,
					qPayExpression.formula,
					qPayExpression.seq,
					qPayExpression.comment
					)
				)
				.from(qPayExpression)
				.innerJoin(qPayItem)
					.on(qPayExpression.companyCode.eq(qPayItem.id.companyCode),
						qPayExpression.payItemCode.eq(qPayItem.id.payItemCode))
				.fetch();
				
	}
	
}
