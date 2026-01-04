package com.like.system.hierarchycode.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.like.system.hierarchycode.application.dto.QCodeHierarchy;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryDTO;
import com.like.system.hierarchycode.application.port.in.treequery.HierarchyCodeTreeQueryResultDTO;
import com.like.system.hierarchycode.domain.QCode;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Primary
@Repository
public class HieraryCodeTreeQuerydsl {

	JPAQueryFactory	queryFactory;
	final QCode qCode = QCode.code1;				
	
	HieraryCodeTreeQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
		
	public List<HierarchyCodeTreeQueryResultDTO> getCodeHierarchyList(HierarchyCodeTreeQueryDTO dto) { 							
		BooleanBuilder builder = new BooleanBuilder();
		
		builder.and(qCode.id.companyCode.eq(dto.companyCode()))
			   .and(qCode.enabled());
		
		return queryFactory
				.select(this.projection(qCode))
				.from(qCode)
				.where(builder)			
				.orderBy(qCode.hierarchyLevel.asc(), qCode.seq.asc())
				.fetch();
	}	
	
	private QCodeHierarchy projection(QCode qCode) {		
		return new QCodeHierarchy(				
				qCode.id.codeId,
				qCode.id.companyCode,				
				qCode.code, 
				qCode.codeName, 
				qCode.codeNameAbbreviation,
				qCode.parentCode.id.codeId,
				qCode.fromDate, 
				qCode.toDate, 
				qCode.seq, 
				qCode.cmt);		
	}

}
