package com.like.system.webresource.adapter.out.db.querydsl;

import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.webresource.application.port.in.query.WebResourceQueryDTO;
import com.like.system.webresource.application.port.in.query.WebResourceQueryResultDTO;
import com.like.system.webresource.domain.QWebResource;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class WebResourceQuerydsl {

	JPAQueryFactory queryFactory;
	
	private final QWebResource qWebResource = QWebResource.webResource;
	
	public WebResourceQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<WebResourceQueryResultDTO> getList(WebResourceQueryDTO dto) {
		return queryFactory
				.select(Projections.fields(WebResourceQueryResultDTO.class,							
						qWebResource.id.as("resourceId"),
						qWebResource.name.as("resourceName"),
						qWebResource.type.as("resourceType"),
						qWebResource.url,
						qWebResource.description
						)
				)
				.from(qWebResource)
				.where(
						likeResourceCode(dto.resourceCode()),
						likeResourceName(dto.resourceName()),
						likeResourceType(dto.resourceType()),
						likeUrl(dto.url()),
						likeDescription(dto.description())
				)
				.fetch();
				           
	}
	
	
	public WebResourceQueryResultDTO get(WebResourceQueryDTO dto) {
		return queryFactory
				.select(Projections.fields(WebResourceQueryResultDTO.class,							
						qWebResource.id.as("resourceId"),
						qWebResource.name.as("resourceName"),
						qWebResource.type.as("resourceType"),
						qWebResource.url,
						qWebResource.description
						)
				)
				.from(qWebResource)				
				.fetchFirst();
				           
	}
	
	private BooleanExpression likeResourceCode(String resourceCode) {
		return hasText(resourceCode) ? qWebResource.id.like("%"+resourceCode+"%") : null;					
	}
	
	private BooleanExpression likeResourceName(String resourceName) {
		return hasText(resourceName) ? qWebResource.name.like("%"+resourceName+"%") : null;					
	}
	
	private BooleanExpression likeResourceType(String resourceType) {
		return hasText(resourceType) ? qWebResource.type.like("%"+resourceType+"%") : null;			
	}
	
	private BooleanExpression likeUrl(String url) {
		return hasText(url) ? qWebResource.url.like("%"+url+"%") : null;					
	}
	
	private BooleanExpression likeDescription(String description) {
		return hasText(description) ? qWebResource.description.like("%"+description+"%") : null;
	}
}
