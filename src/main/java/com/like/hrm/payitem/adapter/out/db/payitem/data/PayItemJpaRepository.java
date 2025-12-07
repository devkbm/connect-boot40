package com.like.hrm.payitem.adapter.out.db.payitem.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.payitem.domain.payitem.PayItem;
import com.like.hrm.payitem.domain.payitem.PayItemId;

public interface PayItemJpaRepository extends JpaRepository<PayItem, PayItemId>, QuerydslPredicateExecutor<PayItem> {

}
