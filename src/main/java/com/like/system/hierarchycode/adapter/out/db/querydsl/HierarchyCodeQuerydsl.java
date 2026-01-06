package com.like.system.hierarchycode.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.hierarchycode.application.port.in.query.HierarchyCodeQueryResultDTO;
import com.like.system.hierarchycode.domain.QCode;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class HierarchyCodeQuerydsl {

	JPAQueryFactory	queryFactory;
	final QCode qCode = QCode.code1;
	
	HierarchyCodeQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<HierarchyCodeQueryResultDTO> query() {
		
		return queryFactory
				.select(Projections.fields(HierarchyCodeQueryResultDTO.class,
						qCode.id.companyCode,
						qCode._parentCode.as("parentCodeId"),
						qCode.id.codeId,
						qCode.code,
						qCode.codeName,
						qCode.codeNameAbbreviation,
						qCode.fromDate,
						qCode.toDate,
						qCode.hierarchyLevel,
						qCode.lowLevelCodeLength,
						qCode.seq,
						qCode.cmt
						)
				)
				.from(qCode)							
				.fetch();
	}
	
}
