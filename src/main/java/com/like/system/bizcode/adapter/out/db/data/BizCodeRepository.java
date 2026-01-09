package com.like.system.bizcode.adapter.out.db.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.like.system.bizcode.adapter.out.db.entity.JpaBizCode;
import com.like.system.bizcode.adapter.out.db.entity.JpaBizCodeId;

public interface BizCodeRepository extends JpaRepository<JpaBizCode, JpaBizCodeId> {

}
