package com.like.hrm.payitem.adapter.out.db.payitemstaff.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.like.hrm.payitem.domain.payitemstaff.PayItemStaff;

public interface PayItemStaffJpaRepository extends JpaRepository<PayItemStaff, Long>, QuerydslPredicateExecutor<PayItemStaff> {

}
