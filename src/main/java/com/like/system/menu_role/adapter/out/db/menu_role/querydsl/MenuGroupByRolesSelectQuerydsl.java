package com.like.system.menu_role.adapter.out.db.menu_role.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.QMenuGroup;
import com.like.system.menu_role.domain.menu_role.QMenuRoleMapping;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class MenuGroupByRolesSelectQuerydsl {

	JPAQueryFactory queryFactory;	
	private final QMenuGroup qMenuGroup = QMenuGroup.menuGroup;
	private final QMenuRoleMapping qMenuRoleMapping = QMenuRoleMapping.menuRoleMapping;
	
	MenuGroupByRolesSelectQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public List<MenuGroup> select(String companyCode, List<String> roleCodes) {		
		return this.queryFactory
				.select(qMenuGroup).distinct()
	            .from(qMenuGroup)
	            .innerJoin(qMenuRoleMapping)
		            .on(qMenuGroup.id.companyCode.eq(qMenuRoleMapping.id.companyCode),
		            	qMenuGroup.id.menuGroupCode.eq(qMenuRoleMapping.id.menuGroupCode))
	            .where(qMenuRoleMapping.id.roleCode.in(roleCodes))
	            .orderBy(qMenuGroup.sequence.asc())
	            .fetch();				               
	}
}
