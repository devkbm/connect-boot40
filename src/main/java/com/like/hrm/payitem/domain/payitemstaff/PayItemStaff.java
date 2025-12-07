package com.like.hrm.payitem.domain.payitemstaff;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.common.vo.LocalDatePeriod;
import com.like.core.jpa.domain.AbstractAuditEntity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "HRMPAYITEMSTAFF")
@EntityListeners(AuditingEntityListener.class)
public class PayItemStaff extends AbstractAuditEntity {

	@Id
	@Tsid
	@Column(name="PAY_ITEM_STAFF_ID")	
	Long id;
		
	@Column(name="ORG_CD")
	String companyCode;

	@Column(name="STAFF_NO")
	String staffNo;
	
	@Column(name="PAY_ITEM_CODE")
	String payItemCode;
	
	@Embedded
	LocalDatePeriod priod;
	
	@Column(name="WAGE_AMOUNT")
	BigDecimal wageAmount;
	
	@Column(name="CMT")
	String comment;	
	
	public PayItemStaff(
			String companyCode,
			String staffNo,
			String payItemCode,
			LocalDatePeriod priod,
			BigDecimal wageAmount,
			String comment
			) {
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.payItemCode = payItemCode;
		this.priod = priod;
		this.wageAmount = wageAmount;
		this.comment = comment;
	}
	
	public void modify(
			String payItemCode,
			LocalDatePeriod priod,
			BigDecimal wageAmount,
			String comment
			) {
		this.payItemCode = payItemCode;
		this.priod = priod;
		this.wageAmount = wageAmount;
		this.comment = comment;
	}
	
}
