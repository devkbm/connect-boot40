package com.like.hrm.payitem.adapter.out.db.payinfo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.payitem.domain.payinfo.PayStaffInfo;

public interface PayStaffInfoJpaRepository extends JpaRepository<PayStaffInfo, String>, QuerydslPredicateExecutor<PayStaffInfo> {

}
