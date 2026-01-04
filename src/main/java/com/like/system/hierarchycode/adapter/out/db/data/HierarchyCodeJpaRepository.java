package com.like.system.hierarchycode.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.like.system.hierarchycode.domain.Code;
import com.like.system.hierarchycode.domain.CodeId;

@Repository
public interface HierarchyCodeJpaRepository extends JpaRepository<Code, CodeId>, QuerydslPredicateExecutor<Code> {		
		
}
