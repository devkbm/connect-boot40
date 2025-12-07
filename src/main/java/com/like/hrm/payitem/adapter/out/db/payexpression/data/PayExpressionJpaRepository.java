package com.like.hrm.payitem.adapter.out.db.payexpression.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.payitem.domain.payexpression.PayExpression;

public interface PayExpressionJpaRepository extends JpaRepository<PayExpression, Long>, QuerydslPredicateExecutor<PayExpression> {

}
