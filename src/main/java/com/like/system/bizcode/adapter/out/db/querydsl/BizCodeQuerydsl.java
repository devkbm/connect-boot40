package com.like.system.bizcode.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.bizcode.adapter.out.db.entity.QJpaBizCode;
import com.like.system.bizcode.application.port.in.code.query.BizCodeQueryResultDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class BizCodeQuerydsl {

	private JPAQueryFactory	queryFactory;
	private static final QJpaBizCode qBizCode = QJpaBizCode.jpaBizCode;
		
	public BizCodeQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;		
	}
	
	public List<BizCodeQueryResultDTO> query(String companyCode, String typeId) {	
		return queryFactory
				.select(Projections.fields(BizCodeQueryResultDTO.class,
						qBizCode.modifiedAppUrl.as("clientAppUrl"),
						qBizCode.id.bizCodeTypeId.companyCode,
						qBizCode.id.bizCodeTypeId.typeId,
						qBizCode.id.code,
						qBizCode.useYn,
						qBizCode.sequence,
						qBizCode.comment
						)
				)
				.from(qBizCode)
				.where(qBizCode.id.bizCodeTypeId.companyCode.eq(companyCode)
				  .and(qBizCode.id.bizCodeTypeId.typeId.eq(typeId)))
				.fetch();
	}

}
