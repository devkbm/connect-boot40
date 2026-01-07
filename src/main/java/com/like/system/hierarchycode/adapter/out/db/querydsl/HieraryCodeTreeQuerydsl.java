package com.like.system.hierarchycode.adapter.out.db.querydsl;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryResultDTO;
import com.like.system.hierarchycode.domain.QCode;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class HieraryCodeTreeQuerydsl {

	JPAQueryFactory	queryFactory;
	final QCode qCode = QCode.code1;				
	
	HieraryCodeTreeQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
		
	public List<HierarchyCodeTreeQueryResultDTO> getCodeHierarchyList(HierarchyCodeTreeQueryDTO dto) { 							
					
		return queryFactory
				.select(Projections.fields(HierarchyCodeTreeQueryResultDTO.class,
						qCode._parentCode.as("parentId"),
						qCode.id.codeId.as("id"),
						qCode.id.companyCode,
						qCode.code,
						qCode.codeName,
						qCode.codeNameAbbreviation,						
						qCode.cmt,
						qCode.fromDate,
						qCode.toDate,
						qCode.seq,						
						qCode.codeName.concat(" - ").concat(qCode.code).as("title"),
						qCode.id.codeId.as("key")
						)
				)
				.from(qCode)
				.where(	
						qCode.enabled(),
						eqCompanyCode(dto.companyCode())						
				)
				.orderBy(qCode.hierarchyLevel.asc(), qCode.seq.asc())
				.fetch();
	}	
	
	private BooleanExpression eqCompanyCode(String companyCode) {
		return hasText(companyCode) ? qCode.id.companyCode.eq(companyCode) : null;					
	}	
		
}
