package com.like.hrm.payitem.adapter.out.db.paytable.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.payitem.domain.paytable.PayTable;

public interface PayTableJpaRepository extends JpaRepository<PayTable, Long>, QuerydslPredicateExecutor<PayTable> {

}
