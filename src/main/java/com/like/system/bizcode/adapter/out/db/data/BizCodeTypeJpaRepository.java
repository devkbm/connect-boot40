package com.like.system.bizcode.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeType;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeTypeId;

public interface BizCodeTypeJpaRepository extends JpaRepository<JpaBizCodeType, JpaBizCodeTypeId> {

}
